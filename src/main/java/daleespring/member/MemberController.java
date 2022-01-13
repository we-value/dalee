package daleespring.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "member/")
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    @GetMapping("join")
    public String MemberJoin(Model model){

        model.addAttribute("memberJoinForm", new MemberJoinForm());
        return "member/member_join";
    }

    @PostMapping("join")
    public String MemberJoin(@Valid MemberJoinForm memberJoinForm, BindingResult memberFormBindingResult){

        memberPwdAndEmailValidate(memberJoinForm, memberFormBindingResult);
        if (memberFormBindingResult.hasErrors()) {
            return "member/member_join";
        }

        Member member = new Member();
        member.setMemberEmail(memberJoinForm.getEmail());
        member.setMemberPassword(memberJoinForm.getPassword());
        member.setMemberNickname(memberJoinForm.getNickname());

        memberService.memberJoin(member);

        return "feed/feed_list";
    }

    private void memberPwdAndEmailValidate(MemberJoinForm memberJoinForm, BindingResult memberFormBindingResult) {
        if(!memberRepository.findByEmailMember(memberJoinForm.getEmail()).isEmpty()){
            memberFormBindingResult.rejectValue("email", "code","이미 존재하는 이메일입니다.");
        }
        if(!memberRepository.findByNicknameMember(memberJoinForm.getNickname()).isEmpty()){
            memberFormBindingResult.rejectValue("nickname", "code","이미 존재하는 닉네임입니다.");
        }
        if(!memberJoinForm.getPassword().equals(memberJoinForm.getPasswordCheck())){
            memberFormBindingResult.rejectValue("password", "code","비밀번호가 일치하지 않습니다!");
            memberFormBindingResult.rejectValue("passwordCheck", "code","비밀번호가 일치하지 않습니다!");
        }
    }

}