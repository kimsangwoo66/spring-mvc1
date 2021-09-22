package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

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
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        ///front-controller/v1/members 이라는 자원을 요청하면 MemberFormControllerV1()) 객체 인스턴스가 반환된다.
        //즉 /front-controller/v1/members 키를 넣으면 new MemberFormControllerV1() 이라는 값이 반환
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        //컨트롤러를 찾아서 맵핑
        //다형성에 의해서 인터페이스로 받을 수 있다.
        //쉽게 말해서 부모는 자식을 받을 수 있다.
        ControllerV4 controller = controllerMap.get(requestURI);
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        //paramMap
        //메소드를 뽑아낸 상태
        Map<String, String> paramMap = getStringStringMap(request);
        //v3와 다른점 -> 모델객체를 프론트 컨트롤러에 생성해서 넘겨준다.
        //컨트롤러에서 모델 객체에 값을 담으면 여기에 그대로 담겨있게 된다.
        Map<String, Object> model = new HashMap<>(); //추가
        //cmd opt b = 참조한 구현체들에 대해 확인할 수있다.
        String viewName = controller.process(paramMap, model);


        //ex) /WEB-INF/views/new-form.jsp
        MyView view = viewResolver(viewName);

        //랜더링 함수 호출후 jsp에 포워딩
        view.render(model,request,response);



    }

    private MyView viewResolver(String viewName) {
        //실제 논리 이름 생성
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    //cmd + opt + m = 메소드 추출 , 비슷한 레벨환경으로 맞추기 위해서
    private Map<String, String> getStringStringMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        //paramMap 으로 모든 파라미터값을 다 꺼내온다.
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
