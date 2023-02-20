package project.PointWeb.controller;

import Domain.Member;
import Dto.MemberLoginDto;
import Dto.MemberRegisterDto;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDateTime;

@Controller
public class MemberController {

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

    }
}
