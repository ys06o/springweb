package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller  //http 기능+빈 등록 기능
public class RestController2 {

    //1.100을 반환하는 메소드
    @GetMapping("/day02/task") //was(tomcat)주소/내가 정의한 주소,localhost:8080/day02/task
    @ResponseBody //@ResponseBody:응답 자료 자동 타입변환
    // java=객체지향 http=문자
    //즉 자바타입을 자동으로 http contents 타입으로 변환해준다. int->application/json
    public int method1(){
        System.out.println("RestController2.method1");
        return 100;
    }

    //2.문자열 반환하는 메소드 java String->text/plain
    @GetMapping("/day02/task2") @ResponseBody
    public String method2() {
        System.out.println("RestController2.method2");
        return "유재석";
    }

    //3.Map 타입을 반환하는 메소드
    @GetMapping("/day02/task3")  @ResponseBody
    public Map<String, Object> method3() {
        Map<String, Object> map = new HashMap<>();
        map.put("유재석", 100);
        map.put("강호동", 90);
        return map;
    }

    //4.boolean 타입 반환
    @GetMapping("day02/task4")
    @ResponseBody //java boolean->application/json
    public boolean method4() {
        return true;
    }

    //5.DTO 반환하는 메소드
    @GetMapping("/day02/task5")
    @ResponseBody
    public TaskDto method5(){
        TaskDto taskDto=new TaskDto();
        taskDto.name = "유재석";
        taskDto.point=10;
        return taskDto;
    }
} //class end


//즉 String을 제외한 java의 대부분 타입은 application/json 으로 HTTP content-type 으로 설정된다.
class TaskDto{
    String name;
    int point;
} //class end
