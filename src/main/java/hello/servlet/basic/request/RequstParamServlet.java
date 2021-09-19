package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
* 1.파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
*
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequstParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        //모든 요청 파라미터를 다 꺼낼 수 있다.
        reqeust.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println("paramName = " + paramName));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = reqeust.getParameter("username");
        String age = reqeust.getParameter("age");

        System.out.println("name = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = reqeust.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");

    }
}
