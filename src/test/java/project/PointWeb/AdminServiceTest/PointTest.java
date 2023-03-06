package project.PointWeb.AdminServiceTest;


import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberRegisterDto;
import project.PointWeb.Service.MemberBasicService;
import project.PointWeb.Repository.MemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Transactional
@Rollback
public class PointTest {

    @Autowired MemberRepository memberRepository;
    @Autowired
    MemberBasicService memberBasicService;

    @Test
    void 포인트_지급_테스트() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberBasicService.save(member);

        Optional<Member> id = memberRepository.findBymemberId("test");

        if(id.isPresent()){
            Member member1 = memberRepository.findByid(id.get().getId());
            member1.add_point(1000L);
            Assertions.assertThat(member1.getCurrent_point()).isEqualTo(2000L);
        }
        else{
            fail("회원 가입 실패");
        }



    }

    @Test
    void 포인트_차감_테스트_0이상() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberBasicService.save(member);

        Optional<Member> id = memberRepository.findBymemberId("test");

        if(id.isPresent()){
            Member member1 = memberRepository.findByid(id.get().getId());
            member1.minus_point(500L);
            Assertions.assertThat(member1.getCurrent_point()).isEqualTo(500L);
        }
        else{
            fail("회원 가입 실패");
        }



    }

    @Test
    void 포인트_차감_테스트_0이하() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberBasicService.save(member);

        Optional<Member> id = memberRepository.findBymemberId("test");

        if(id.isPresent()){
            Member member1 = memberRepository.findByid(id.get().getId());
            member1.minus_point(2000L);
            Assertions.assertThat(member1.getCurrent_point()).isEqualTo(0L);
        }
        else{
            fail("회원 가입 실패");
        }



    }

}
