package project.PointWeb.Controller.AdminController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Repository.ResignRepository;

import java.net.http.HttpRequest;

@Controller

@Slf4j

public class AdminBasicController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired ResignRepository resignRepository;


    @GetMapping("/admin/main")
    public String main(Model model, HttpSession httpSession){

        Object host = httpSession.getAttribute("host");

        if(host!=null){

        model.addAttribute("members", memberRepository.findAll());
        return "/admin/main";

        }

        else{
            return "redirect:/";
        }

    }

    @GetMapping("/admin/member")
    public String member(Model model, HttpSession httpSession){

        Object host = httpSession.getAttribute("host");

        if(host!=null){

            model.addAttribute("members", memberRepository.findAll());
            return "/admin/member";

        }

        else{
            return "redirect:/";
        }

    }

    @GetMapping("/admin/point")
    public String point(Model model, HttpSession httpSession){

        Object host = httpSession.getAttribute("host");

        if(host!=null){

            model.addAttribute("members", memberRepository.findAll());
            return "/admin/point";

        }

        else{
            return "redirect:/";
        }



    }

    @GetMapping("/admin/resign")
    public String resign(Model model, HttpSession httpSession){

        Object host = httpSession.getAttribute("host");

        if(host!=null){

            model.addAttribute("members", memberRepository.findAll());
            return "/admin/resign";

        }

        else{
            return "redirect:/";
        }




    }




}
