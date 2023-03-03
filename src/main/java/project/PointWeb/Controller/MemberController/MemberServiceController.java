package project.PointWeb.Controller.MemberController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.PointWeb.Domain.Member;
import project.PointWeb.Repository.MemberRepository;

import java.util.Optional;

@Controller
public class MemberServiceController {

    @Autowired MemberRepository memberRepository;


    // 로그인 성공한 회원, 회원 페이지로 이동

    @GetMapping("/member/{id}")
    public String login(@PathVariable Long id, Model model){

        Optional<Member> member = Optional.ofNullable(memberRepository.findByid(id));

        if(member.isPresent()){
        model.addAttribute("member",member);

        return "member/main";
        }

        else{
            return "redirect:/login";
        }

}

}
