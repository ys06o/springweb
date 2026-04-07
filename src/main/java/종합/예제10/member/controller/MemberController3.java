package 종합.예제10.member.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.member.dto.MemberDto;
import 종합.예제10.member.service.JWTService;
import 종합.예제10.member.service.MemberService;

@RestController
@RequestMapping("/api/member3")
@RequiredArgsConstructor
@CrossOrigin( value = "http://localhost:5173",allowCredentials = "true")
public class MemberController3 {

    private final MemberService memberService;
    private final JWTService jwtService; // jwt 기능 객체

    //1.회원가입

    // [2] 로그인 = 세션방식 ---> 토큰방식 변경
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody MemberDto loginDto
            ,HttpServletResponse response){ //HttpServletResponse:응답 객체
        boolean result = memberService.login( loginDto );
        // 1] 만약에 로그인 성공이면
        if( result ){
            String token = jwtService.createToken( loginDto.getMid() ); // 2] 로그인성공한 정보(아이디) 토큰에 저장
            //==========쿠키에 토큰을 담아서 응답하기====================
            //(1) 쿠키에 토큰 담기 ,new Cookie("속성명",값);
            Cookie cookie=new Cookie("token",token);
                //쿠키 옵션
            cookie.setHttpOnly(true); //쿠키 접근 방법:true이면 js가 접근 못한다.
            cookie.setSecure(false); //.setSecure(true):true이면 https만 접근 가능
            cookie.setPath("/"); //.setPath:쿠키가 접근하는 경로 허용 경로
            //(2)쿠키 응답하기,response.addCookie(내가만든 쿠키객체);
            response.addCookie(cookie);
            return ResponseEntity.ok(true);
        }
        // 3] 아니면 로그인 실패
        return ResponseEntity.ok( false );
    }

    //3.로그아웃
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){

        // 1) 매개변수에 HttpServletResponse response 받는다.
        // 2) 동일한 속성명으로 null값을 저장한느 쿠키 생성
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0); //쿠키에 생명주기를 0으로 설정한다.
        cookie.setPath("/");
        //3.쿠키 반환하기
        response.addCookie(cookie);
        // 3) 반환
        return ResponseEntity.ok( true );
    }
    //4.마이페이지
    @GetMapping("/my/info")
    public ResponseEntity<?> myInfo(@CookieValue(value = "token",required = false) String token){
        // @CookieValue : HTTP 요청의 cookie 정보 매핑
        // 1] @CookieValue(value = "token",required = false)String token 매개변수로 받는다.
        // 2] 쿠키안에 토큰이없으면 비로그인
        if( token == null){
            return ResponseEntity.ok( false );
        }
        String mid = jwtService.getClaim( token );
        if( mid == null ) return ResponseEntity.ok( false ); // 토큰 문제로 실패
        // 5] 토큰에서 꺼낸 값(mid) 으로 회원정보 요청해서 반환하기
        return ResponseEntity.ok( memberService.myinfo(mid) );
    }
} //class end


/*

    HTTP:문자이동 규칙/규약
   톰캣 세션:서버의 저장됨, 보안이 높음   ,로그인


    VS 쿠키
        토큰이란? 특정한 자료를 암호화 해서 인증

        쿠키:브라우저에 저장


        **활용
        1.토큰은  세션/쿠키 없이 http를 사용하지 않으므로 웹/앱 통합 가능
        2.쿠키는 브라우저에 저장하므로 보안이 상대적으로 낮지만 jwt와 같이 사용하며 서버에 과부화를 줄일 수 있다.
 */