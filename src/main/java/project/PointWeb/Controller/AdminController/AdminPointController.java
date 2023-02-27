package project.PointWeb.Controller.AdminController;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.PointWeb.Domain.Member;
import project.PointWeb.Repository.MemberRepository;

import java.util.Optional;

@Controller

public class AdminPointController {

    @Autowired MemberRepository memberRepository;

    @Transactional
    @PostMapping("/admin/point/add")
    public String add(@RequestParam("memberId") String memberId, @RequestParam("add_point") Long add_point, Model model){

        Optional<Member> id = memberRepository.findBymemberId(memberId);

        if(id.isPresent()){
            Member member = memberRepository.findByid(id.get().getId());
            member.add_point(add_point);
            model.addAttribute("add_success",memberId+" 에게 "+add_point +"점 지급했습니다.");
            return "admin/add_success";
        }
        else{
            model.addAttribute("add_fail","등록되지 않은 회원입니다.");
            return "admin/add_fail";
        }


    }

    @PostMapping("/admin/point/minus")
    public String minus(@RequestParam("memberId") String memberId, @RequestParam("add_point") Long add_point, Model model){
        return "0";
    }
}
