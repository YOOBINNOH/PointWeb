package project.PointWeb.controller;


import org.springframework.ui.Model;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberLoginDto;
import project.PointWeb.Dto.MemberRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.PointWeb.Service.MemberService;


import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MemberController {

    final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login_check(MemberLoginDto memberLoginDto, Model model){

        LocalDateTime login_date = LocalDateTime.now();

        // 로그인 체크 기능

        String loginId = memberLoginDto.getMemberId();
        Long loginPw = memberLoginDto.getMemberPw();


        if(memberService.login_check(loginId,loginPw,login_date) == true){
            return "login_success";
        }
        else{
            model.addAttribute("login_fail","회원 정보가 일치하지 않습니다.");
            return "login_fail";
        }



    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register_check(MemberRegisterDto memberRegisterDto){

        // 회원 가입 성공 시
        LocalDateTime register_date = LocalDateTime.now();

        // 새로운 객체를 만들고 save

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(),memberRegisterDto.getTeamId(),register_date);
        memberService.save(member);


        return "register_success";

    }
}
