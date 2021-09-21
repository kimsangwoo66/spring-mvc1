package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//프론트 컨트롤러는 인터페이스를 호출해서 구현과 관계없이 로직의 일관성을 가져간다.
//front-controller/v1/* 의 하위 호출을 요청하면 전부 이 서블릿이 실행된다.
//내부 로직은 서블릿과 비슷하다.
@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        ///front-controller/v1/members 이라는 자원을 요청하면 MemberFormControllerV1()) 객체 인스턴스가 반환된다.
        //즉 /front-controller/v1/members 키를 넣으면 new MemberFormControllerV1() 이라는 값이 반환
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        //컨트롤러를 찾아서 맵핑
        //다형성에 의해서 인터페이스로 받을 수 있다.
        //쉽게 말해서 부모는 자식을 받을 수 있다.
        ControllerV2 controller = controllerMap.get(requestURI);
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //cmd opt b = 참조한 구현체들에 대해 확인할 수있다.
        //각각의 컨트롤러는 myview객체만 생성해서 반환하면 된다.
        MyView view = controller.process(request, response);

        //랜더링 함수 호출후 jsp에 포워딩
        view.render(request,response);


    }
}
