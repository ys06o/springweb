package example.day02.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Componentscan :스프링 컨테이너에 등록할 빈들을 동일패키지/하위패키지 등록한다.(서버를 실행시킬때)
//@Componentscan:@Controller, @Service @RestController @Repository 등등이 내장됨
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    } //main end
} //class end
