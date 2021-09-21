package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
