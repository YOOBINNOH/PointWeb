package project.PointWeb.Controller;

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

public class AdminMemberController {

    @Autowired MemberRepository memberRepository;


    @PostMapping("/admin/member/delete")
    public String DeleteMember(@RequestParam("memberId") String memberId, Model model){
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

    @Transactional
    @PostMapping("/admin/member/change")
    public String ChangeMemberTeam(@RequestParam("memberId") String memberId, @RequestParam("teamId") Long teamId, Model model){

        Optional<Member> id = memberRepository.findBymemberId(memberId);

        if(teamId<1 || teamId>10){
            model.addAttribute("change_count_fail","팀 번호는 1~10 까지의 자연수만 가능합니다.");
            return "admin/change_count_fail";
        }

        if(id.isPresent()){
            Member member = memberRepository.findByid(id.get().getId());
            member.change_teamId(teamId);
            model.addAttribute("change_success",memberId +" 팀 변경 성공");
            return "admin/change_success";
        }
        else{
            model.addAttribute("change_fail","등록되지 않은 회원입니다.");
            return "admin/change_fail";
        }


    }
}
