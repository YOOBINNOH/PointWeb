package project.PointWeb.Controller.MemberController;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.PointWeb.Domain.Member;
import project.PointWeb.Repository.MemberRepository;

import java.util.Optional;

@Controller
@Slf4j
public class MemberServiceController {

    @Autowired MemberRepository memberRepository;


    // 로그인 성공한 회원, 회원 페이지로 이동

    @GetMapping("/member/{id}")
    public String login(@PathVariable Long id, Model model){

        Member member = memberRepository.findByid(id);

        model.addAttribute("member",member);

        return "member/main";


}
    // 포인트 선물 기능
    @Transactional
    @PostMapping("/member/point/give")
    public String point_give(@RequestParam("memberId") String memberId, @RequestParam("give_point") Long give_point, Model model){

        Optional<Member> id = memberRepository.findBymemberId(memberId);

        // 선물한 사람의 id 판별 후 그 사람 포인트 감소 필요 -> 포인트 부족 시 error 창 이동



        // 선물한 사람의 id로 model.addattribute 후 회원의 main page 로 이동 시켜야 함

        if(id.isPresent()){
            Member member = memberRepository.findByid(id.get().getId());
            member.add_point(give_point);
            model.addAttribute("give_success",memberId+" 에게 "+give_point +"점 지급했습니다.");
            return "member/give_success";
        }
        else{
            model.addAttribute("give_fail","등록되지 않은 회원입니다.");
            return "member/give_fail";
        }


    }






}
