package project.PointWeb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.PointWeb.Domain.Member;
import project.PointWeb.Repository.MemberRepository;

import java.util.Optional;

@Controller


public class AdminController {

    @Autowired MemberRepository memberRepository;


    @GetMapping("/admin/main")
    public String main(Model model){
        model.addAttribute("members",memberRepository.findAll());
        return "/admin/main";
    }

    @GetMapping("/admin/member")
    public String member(Model model){
        model.addAttribute("members",memberRepository.findAll());
        return "/admin/member";
    }

    @GetMapping("/admin/point")
    public String point(Model model){
        model.addAttribute("members",memberRepository.findAll());
        return "/admin/point";
    }

    @GetMapping("/admin/resign")
    public String resign(Model model){
        model.addAttribute("members",memberRepository.findAll());
        return "/admin/resign";
    }



    @PostMapping("/admin/member")
    public String DeleteMember(@RequestParam("memberId") String memberId,Model model){
       Optional<Member> id = memberRepository.findBymemberId(memberId);

        if(id.isPresent()){
            Member member = memberRepository.findByid(id.get().getId());
            memberRepository.delete(member);
            model.addAttribute("delete_success",memberId+" 회원을 삭제했습니다.");
            return "admin/delete_success";
        }
        else{
            model.addAttribute("delete_fail","등록되지 않은 회원입니다.");
            return "admin/delete_fail";
        }





    }

}
