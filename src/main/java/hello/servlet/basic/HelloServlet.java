package hello.servlet.basic;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//서블릿은 httpservlet을 상속받음

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //브라우저가 이경로로 자원 요청시 동작, urlpatterns는 url 매핑이다.
public class HelloServlet extends HttpServlet { //서블릿이 호출되면 서비스 매서드가 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //http 요청이오면 was=서블릿컨테이너가 html request, response 객체를 만들어서 서블릿에 던저준다.
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("request");
        System.out.println("response = " + response);

        //hello?username=kim 같은 쿼리파라미터를 쉽게 읽어 올수있게 하는 메소드 : getParameter
        String username = request.getParameter("username");
        System.out.println("username =" + username);

        /*
        * 헤더 정보에 들어감*/
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");


        /*write함수는 http message body에 데이터가 들어감
        *
        * */
        response.getWriter().write("hello" + username);


    }
}
