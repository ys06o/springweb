package example.day02.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

//REST란? HTTP GET/POST/PUT/DELETE 활용하여 통신
//Controller란? view(사용자)와 model(dao)사이에 통신 중계
//@Component //spring이 해당 클래스를 이해할수 있게 스프링 컨테이너에 빈 객체 정보 등록 vs싱글톤
@Controller//+HTTP 기능까지 포함된 어노테이션(컨트롤러 안에 component 포함,servlet 포함)
public class RestController1 {
    //HTTP 기능(방법/기능/메소드/행위)

    //1-1 POST:클라이언트가 요청한 http 메소드와 매핑 어노테이션
    @PostMapping
    public void 등록하기() {
        System.out.println("RestController1.등록하기");}

    //1-2 GET
    @GetMapping
    public void 조회하기() {
        System.out.println("RestController1.조회하기");
    }

    //1-3 PUT
    @PutMapping
    public void 수정하기() {
        System.out.println("RestController1.수정하기");
    }

    //1-4 DELETE
    @DeleteMapping
    public void 삭제하기() {
        System.out.println("RestController1.삭제하기");
    }
} //class end
