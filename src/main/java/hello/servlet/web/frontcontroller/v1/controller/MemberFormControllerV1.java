package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewpath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewpath);
        //redirect는 클라이언트에 응답이 다갔다가 클라인어트가 redirect 경로로 다시 요청한다.
        //서버에 2번 호출을 요청한다.
        //forward 는 서버 내부에서 servlet이 jsp를 호출하고 또 그반대로 호출한다. 따라서 클라이언트 입장에서 1번 호출되는 것이다.
        dispatcher.forward(request,response);
    }
}
