package project.PointWeb.Controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Repository.ResignRepository;

@Controller


public class AdminBasicController {

    @Autowired MemberRepository memberRepository;
    @Autowired ResignRepository resignRepository;


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
        model.addAttribute("members",resignRepository.findAll());
        return "/admin/resign";
    }




}
