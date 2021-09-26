package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@controller만 있어도 컴포넌트 스캔의 대상이 된다.
//스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다.
@Controller
public class SpringMemberFormControllerV1 {

    //@RequestMapping은 요청 정보를 매핑한다. 해당 URL이 호출되면 이 메서드가 호출
    //애노테이션 기반으로 동작하기 때문에 메서드의 이름은 임의로 지으면 됨
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process()
    {
        //viewResolver에서 jsp를 처리하기 위해 찾아서 랜더링 된다.
        //모델과 뷰 정보를 담아서 반환하면 된다.
        return new ModelAndView("new-form");

    }
}
