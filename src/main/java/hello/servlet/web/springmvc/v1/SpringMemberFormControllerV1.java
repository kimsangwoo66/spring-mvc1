package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@controller만 있어도 컴포넌트 스캔의 대상이 된다.
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process()
    {
        //viewResolver에서 jsp를 처리하기 위해 찾아서 랜더링 된다.
        return new ModelAndView("new-form");

    }
}
