package project.PointWeb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.PointWeb.Repository.MemberRepository;

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

}
