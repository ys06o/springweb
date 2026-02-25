package example.day02.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//servlet이란? 자바 회사에서 HTTP웹 동적 처리를 하기위한 라이브러리(미리만든) 클래스
//사용법:
//1.현재 클래스의 "HttpServlet"클래스로 부터 상속을 받는다.
//2.현재 클래스 위에 @WebServlet("/URL") 주소 설정 중복없이 맘대로
//3.(스프링환경에만 해당)AppStart 클래스 위에 @ServletComponentScan 주입하여 스프링이 servlet을 찾을수 있도록 한다.
@WebServlet("/day02/servlet") //-->localhost:8080/day02/servlet 요청시 통신 가능한 클래스 정의
public class ServletController extends HttpServlet {

    //순수 자바 메소드
    boolean method(int param){return true;}


    //1.servlet 클래스로 부터 init함수가 최초 1번 실행된다.
    @Override
    public void init() throws ServletException {
        System.out.println("init 함수");
        super.init();
    }


    //2.servlet 클래스로 부터 HTTP요청 마다 service함수가 실행된다.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 함수");
        super.service(req, res);
    }

    //3.HTTP 메소드란? GET,POST,PUT,DELETE 통신 방법 servlet이 제공한다.
    //servlet 객체는 요청이 끝나도 사라지지 않고 다음요청에 재사용한다.
    //HttpServletRequest(요청),HttpServletRequest(응답)는 요청이 끝나면 사라짐
    //3-1 GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doGet");

        //*http 요청시 포함된 매개변수 확인
        String data=req.getParameter("data");
        System.out.println("data = " + data);

        //*http요청시 클라이언트에게 응답
        resp.getWriter().println("hello");
    }

    //3-2 POST,브라우저의 주소 입력창에 요청하는 방식은 무조건 GET 방식이므로 POST,PUT,DELETE는 포스트맨VS탈렌드API 사용

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPost");
        String data=req.getParameter("data");
        System.out.println("data = " + data);
        resp.getWriter().println("HI");
    }

    //3-3 PUT,


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPut");
        String data = req.getParameter("data");
        System.out.println("data = " + data);
        resp.getWriter().println("PUT");
    }

    //3-4 DELETE

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doDelete");
        String data = req.getParameter("data");
        System.out.println("data = " + data);
        resp.getWriter().println("delete");
    }

    //HTTP란? 클라이언트와 서버 간의 통신을 하는 규칙
    //클라이언트가 1번 요청의 1번 응답, 즉 요청이 없으면 응답 x
    //servlet 클래스 내 동일한 시그니처를 갖는 메소드는 존재할수 없다.
    // 즉 하나의 servlet에  doGet()메소드가 1개만 존재 할수 있다. -->스프링에서는 보완을 제공
} //class end
