package project.PointWeb.MemberBasicTest;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberLoginDto;
import project.PointWeb.Dto.MemberRegisterDto;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Controller.MemberController.MemberBasicController;
import project.PointWeb.Service.MemberBasicService;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback
public class LoginBasicTest {

    @Autowired
    MemberBasicController memberController;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberBasicService memberBasicService;


    @Test
    void 아이디_존재_체크_테스트() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberBasicService.save(member);

        MemberLoginDto memberLoginDto = new MemberLoginDto();

        String loginId = "test";
        memberLoginDto.setMemberId(loginId);
        memberLoginDto.setMemberPw(null);

        Optional<Member> result = memberRepository.findBymemberId(loginId);



        try {
            Long id = result.get().getId();
            Member member1 = memberRepository.findByid(id);
            Assertions.assertThat(member1.getMemberId()).isEqualTo("test");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    void 비밀번호_일치_체크_테스트() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberBasicService.save(member);

        MemberLoginDto memberLoginDto = new MemberLoginDto();


        memberLoginDto.setMemberId("test");
        memberLoginDto.setMemberPw(1234L);

        Optional<Member> result = memberRepository.findBymemberId("test");

        Long id = result.get().getId();

        try {
            Member member1 = memberRepository.findByid(id);
            Assertions.assertThat(member1.getMemberPw()).isEqualTo(1234L);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
