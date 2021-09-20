package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//이것을 컨트롤러로 사용한다.
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewpath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewpath);
        //redirect는 클라이언트에 응답이 다갔다가 클라인어트가 redirect 경로로 다시 요청한다.
        //서버에 2번 호출을 요청한다.
        //forward 는 서버 내부에서 servlet이 jsp를 호출하고 또 그반대로 호출한다. 따라서 클라이언트 입장에서 1번 호출되는 것이다.

        dispatcher.forward(request,response);
    }
}
