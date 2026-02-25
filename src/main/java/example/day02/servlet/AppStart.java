package example.day02.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication //스프링부트 환경 의존성(미리 만들어진 코드)주입
//*WAS(웹서버)가 환경설정이 포함된다. -->http localhost:8080
@ServletComponentScan //servlet 클래스를 scan하여
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
        //SpringApplication.run(현재클래스):스프링 실행 함수
        //현재클래스는 @SpringBootApplication 의존성 주입 받은 상태
        // 즉 스프링 환경 세팅된 AppStart에 연결된 상태이므로 AppStart 클래스 실행
        //클래스명.class:클래스 정보 호출
        System.out.println(AppStart.class);
    } //main end
} //class end
