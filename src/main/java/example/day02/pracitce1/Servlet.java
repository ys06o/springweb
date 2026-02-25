package example.day02.pracitce1;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/practice1")
public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value"); //HTTP는 텍스트 전송이 기본값
        int value2 = Integer.parseInt(value);
        //*http요청시 클라이언트에게 응답
        resp.getWriter().println(value2+2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value"); //HTTP는 텍스트 전송이 기본값
        int value2 = Integer.parseInt(value);
        //*http요청시 클라이언트에게 응답
        resp.getWriter().println(value2*2);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value"); //HTTP는 텍스트 전송이 기본값
        int value2 = Integer.parseInt(value);
        //*http요청시 클라이언트에게 응답
        resp.getWriter().println(value2/2);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value"); //HTTP는 텍스트 전송이 기본값
        int value2 = Integer.parseInt(value);
        //*http요청시 클라이언트에게 응답
        resp.getWriter().println(value2%2);
    }
}
