package project.PointWeb.controller;

import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberLoginDto;
import project.PointWeb.Dto.MemberRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.PointWeb.Repository.MemberRepository;
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
    public void login_check(MemberLoginDto memberLoginDto){
        // 로그인 체크 기능 필요


        // 체크 성공 시
        LocalDateTime login_date = LocalDateTime.now();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public void register_check(MemberRegisterDto memberRegisterDto){

        // 회원 가입 성공 시
        LocalDateTime register_date = LocalDateTime.now();

        // 새로운 객체를 만들고 save

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(),memberRegisterDto.getTeamId(),register_date);
        memberService.save(member);


    }
}
