package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 등록 폼 컨트롤러
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    // 회원 컨롤러에서 회원을 실제 등록하는 기능
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        // Member가 만들어짐

        memberService.join(member); // join() → 회원가입할 때
        return "redirect:/"; // 회원가입이 끝났을 때 home 화면으로 보냄
    }

    // 회원 웹 기능 - 조회
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
