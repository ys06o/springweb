package example.day02.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller:view 반환
@RestController //HTTP+빈 등록+ResponseBody 포함= 사용처 값(json) 반환
@RequestMapping("/day02") //해당 컨트롤러내 메소드들이 사용하는 공통 URL을 정의한다.
public class RestController3 {
    //1.클래스가 @RestController이므로 @ResponseBody 생략가능!!!!
    @GetMapping("/task6") //클래스가 @RequestMapping("공통URL/") 가지므로 localhost:8080/day02/~~
    public String method1(){return "서버에게 받을 메소드";}

    //2.http:localhost:8080/day02/task7?name=유재석&&age=40
    @GetMapping("/task7") //쿼리스트링은? URL(웹주소) 뒤로 ? 작성후 매개변수명1=값&&매개변수명2=값
    public int method2(@RequestParam String name,@RequestParam int age){ //쿼리스트링 매개변수명=메소드매개변수명
        // @RequestParam 이란? URL(웹주소) 안에 포함된 쿼리스트링 매개변수 값 가져오는 어노테이션 / *생략가능*
        System.out.println("RestController3.method2");
        System.out.println("name = " + name + ", age = " + age);
        return 7;
    }

    // 3. http:localhost:8080/day02/task8?age=20
    @GetMapping("/task8")
    public int method3(@RequestParam(required = false) String name,@RequestParam(name="age")int 나이){
        // 만약에 쿼리스트링의 매개변수명 과 자바의 매개변수명이 다르면 @RequestParam( name = "쿼리스트링매개변수명")
        // 만약에 쿼리스트링의 매개변수명을 필수로 하지 않을경우 @RequestParam( required = false ) , 기본값은 true
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 8;
    }



    //5.
    @DeleteMapping("/task10") //만약에 여러개 매개변수를 하나의 Map 타입으로 받을 수 있다.
    public int method5(@RequestParam Map<String,Object> map){
        System.out.println("RestController3.method5");
        System.out.println("map = " + map);
        return 10;
    }

    //6.
    @PostMapping("/task11")
    public int method5(@ModelAttribute ExamDto examDto){
        System.out.println("RestController3.method5");
        System.out.println("examDto = " + examDto);
        return 11;
    } //즉 URL?매개변수=값 방식인 쿼리스트링은 URL 상 매개변수 노출이 된다.
    //GET/DELETE->쿼리스트링->@RequestParam/@ModelAttribute
    //POST/PUT->쿼리스트링/BODY본문->@RequestBody
    //즉 URL 상의 매개변수 노출을 가리기 위한 BODY를 사용
    //개인정보나 패스워드 민감한 정보들은 POST/PUT 사용하자
    //예시:편지의 편지봉투:쿼리스트링/ 편지의 내용물:BODY 라고 생각

    //7.HTML-->JS->JAVA(Controller->Dao)
    @PostMapping("/task12")
    public int method12(@RequestBody ExamDto examDto){
        System.out.println("RestController3.method12");
        System.out.println("examDto = " + examDto);
        return 12;
    }

    //8.
    @PutMapping("/task13")
    public int method13(@RequestBody Map<String,Object> map){
        System.out.println("RestController3.method13");
        System.out.println("map = " + map);
        return 13;
    }

    //
} //class end
