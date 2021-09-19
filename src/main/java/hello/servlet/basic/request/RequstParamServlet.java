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
        //content type은 웹브라우저가 만들어 주는것이다.
        //html 폼 데이터 전송은 post전송이다 - 저장
        //request.getparameter은 http 요청 메시지를 통해 클라이언트에서 서버로 데이터를 전송한다.
        //get- 쿼리 파라미터, post - HTML Form 형식: 데이터를 전달하면 HTTP 메시지에 해당 데이터를 포함해서 보내기 떄문에
        //바디에 포함된 데이터가 어떤 형식인지 content-type을 꼭 지정해야함
        //Http message body  전부 지원
        response.getWriter().write("ok");

    }
}
