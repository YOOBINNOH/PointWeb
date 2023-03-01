package project.PointWeb.Controller.MemberController;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberLoginDto;
import project.PointWeb.Dto.MemberRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.MemberService.MemberService;


import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberBasicController {

    final MemberService memberService;
    final MemberRepository memberRepository;

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    // 로그인

    @PostMapping("/login")
    public String login_check(@Validated @ModelAttribute MemberLoginDto memberLoginDto, BindingResult bindingResult, Model model){

        LocalDateTime login_date = LocalDateTime.now();


        String loginId = memberLoginDto.getMemberId();
        Long loginPw = memberLoginDto.getMemberPw();

        if(bindingResult.hasErrors()){
            return "login/login";
        }

        // 관리자 로그인 시 관리자 페이지로 이동
        if(loginId.equals("host") && loginPw.equals(1234L)){

            return "redirect:/admin/main";
        }


        // 로그인 성공 시

        else if(memberService.login_check(loginId,loginPw,login_date) == true){
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
    public String register_check(@Validated @ModelAttribute MemberRegisterDto memberRegisterDto,BindingResult bindingResult, Model model){

        //Id 중복 체크 기능

        String check_id = memberRegisterDto.getMemberId();

        if(bindingResult.hasErrors()){
            return "register/register";
        }

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

            model.addAttribute("register_success","회원가입이 성공했습니다. 다시 로그인 해주세요.");

            return "register/register_success";
        }
    }
}
