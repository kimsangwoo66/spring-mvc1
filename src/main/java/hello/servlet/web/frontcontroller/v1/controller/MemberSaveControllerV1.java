package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//다형성 개발에 익숙해져야 한다.
public class MemberSaveControllerV1 implements ControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         /*get 방식의 쿼리 스트림에서 꺼내든 post방식의 form 이든 request.getParameter 로 보낼 수 있다.
        이전의 서블릿 코드랑 똑같다.
        1.파라미터를 받는다.
        */
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        /*
         * 2.비즈니스 로직 호출
         * */
        Member member = new Member(username, age);
        memberRepository.save(member);

        //3.Model에 데이터를 보관한다.
        request.setAttribute("member", member);

       /*
        WEB-INF/ 있는 자원들은 외부에서 호출해도 그냥 호출되지 않는다.(브라우저에서 WEB-INF 경로를 요청하는것)
        항상 컨트롤러(서블릿)을 거쳐서 내부에서 포워드를 해야 호출된다.
        4.뷰에 던진다.
        */
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //내부에서 서블릿이 jsp 호출, view로 제어권이 넘어감
        dispatcher.forward(request,response);
    }
}
