package project.PointWeb.Controller.MemberController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
import project.PointWeb.Domain.Resign;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Repository.ResignRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@Slf4j
public class MemberServiceController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired ResignRepository resignRepository;

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
    public String point_give(@RequestParam("memberId") String memberId, @RequestParam("give_point") Long give_point, @RequestParam("Id") String Id, Model model) {


        // Id : 선물한 사람 아이디
        // memberId : 선물 받은 사람 아이디

        // 선물한 사람의 id 판별 후 그 사람 포인트 감소 필요 -> 포인트 부족 시 error 창 이동

        Optional<Member> member1 = memberRepository.findBymemberId(Id);
        Optional<Member> member2 = memberRepository.findBymemberId(memberId);

        Long id = member1.get().getId();

        if (member1.isPresent()) {

            // point 지급 성공 -> Service 로 분리 필요
            if (member1.get().getCurrent_point() >= give_point && member2.isPresent()) {

                member1.get().minus_point(give_point);
                member1.get().give_point(give_point);

                member2.get().add_point(give_point);
                member2.get().receive_point(give_point);

                model.addAttribute("give_success", memberId + " 에게 " + give_point + "점 지급했습니다.");
                model.addAttribute("id",id);

                return "member/give_success";
            }

            // point 지급 실패
            else {
                // 선물할 회원이 없는 경우
                if (member2.isPresent() == false) {

                    model.addAttribute("give_fail", "등록되지 않은 회원입니다.");
                    model.addAttribute("id",id);

                    return "member/give_fail";
                }
                if (member1.get().getCurrent_point() < give_point) {

                    model.addAttribute("give_fail", "포인트가 부족합니다.");
                    model.addAttribute("id",id);

                    return "member/give_fail";
                }

            }
        }

        return "redirect:/login/login";
    }




    // 회원 탈퇴 기능
    @Transactional
    @PostMapping("/member/resign")
    public String resign(@RequestParam("id") Long id, Model model, HttpServletRequest request){

        Member member = memberRepository.findByid(id);

        LocalDateTime register_date = LocalDateTime.now();

        Resign resign = new Resign(member.getMemberId(), register_date);

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        resignRepository.save(resign);

        memberRepository.delete(member);

        model.addAttribute("resign_success","회원 탈퇴하셨습니다.");

        return "member/resign_success";
    }

}




