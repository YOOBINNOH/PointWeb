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
        return "login/login";
    }

    @PostMapping("/login")
    public String login_check(MemberLoginDto memberLoginDto, Model model){

        LocalDateTime login_date = LocalDateTime.now();

        // 로그인 체크 기능

        String loginId = memberLoginDto.getMemberId();
        Long loginPw = memberLoginDto.getMemberPw();


        // 로그인 성공 시

        if(memberService.login_check(loginId,loginPw,login_date) == true){
            return "login/login_success";
        }

        // 로그인 실패 시

        else{
            model.addAttribute("login_fail","회원 정보가 일치하지 않습니다.");
            return "login/login_fail";
        }



    }

    @GetMapping("/register")
    public String register(){
        return "register/register";
    }


    @PostMapping("/register")
    public String register_check(MemberRegisterDto memberRegisterDto, Model model){

        //Id 중복 체크 기능

        String check_id = memberRegisterDto.getMemberId();

        if(memberService.duplicate_check(memberRegisterDto.getMemberId()) == false){
            model.addAttribute("duplicate_fail","이미 사용 중인 아이디 입니다.");
            return "register/register_duplicate";
        }
        else if(memberService.isname_test_check(check_id) == false){
            model.addAttribute("Isname_test_fail","아이디 이름으로 test 는 사용할 수 없습니다.");
            return "register/register_Isname_test";
        }

        else {
            // 회원 가입 성공 시
            LocalDateTime register_date = LocalDateTime.now();

            // 새로운 객체를 만들고 save

            Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), register_date);
            memberService.save(member);


            return "register/register_success";
        }
    }
}
