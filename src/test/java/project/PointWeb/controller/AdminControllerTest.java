package project.PointWeb.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberRegisterDto;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Service.MemberService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback
class AdminControllerTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void 멤버_삭제_테스트() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("detc");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberService.save(member);

        Optional<Member> id = memberRepository.findBymemberId("detc");

        if(id.isPresent()){
            Member member1 = memberRepository.findByid(id.get().getId());
            memberRepository.delete(member1);
        }
        else{
            fail("회원 가입 실패");
        }

        if(memberRepository.findBymemberId("detc").isPresent()){
            fail("회원 삭제 실패");
        }

    }
}