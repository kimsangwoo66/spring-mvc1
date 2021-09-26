package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping은 요청 정보를 매핑한다. 해당 URL이 호출되면 이 메서드가 호출
    //애노테이션 기반으로 동작하기 때문에 메서드의 이름은 임의로 지으면 됨

    //method = requestMethod.get은 메소드가 get인 경우에만 호출이 된다.
    @GetMapping("/new-form")
    public String newForm()
    {
        return "new-form";
    }


    //method = requestMethod.get은 메소드가 post인 경우에만 호출이 된다.
    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping(value = "/save")
    public String save(
            //요청 파라미터를 받는다.
            @RequestParam("username") String username,
            @RequestParam("age") int age,
                             Model model) {


        Member member = new Member(username,age);
        //비즈니스 로직을 태운다.
        memberRepository.save(member);


        //모델에 담는다.
        model.addAttribute("member", member);

        //뷰에 반환
        return "save-result";

    }


    //@RequestMapping(method = RequestMethod.GET)
    //아래 어노테이션과 같은 기능이다. 쯕어노테이션을 위한 어노테이션도 같이 제공한다.
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

}
