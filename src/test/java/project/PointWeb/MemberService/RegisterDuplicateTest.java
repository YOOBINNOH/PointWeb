package project.PointWeb.MemberService;


import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberRegisterDto;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Controller.MemberBasicController;


@SpringBootTest
@Transactional
@Rollback
public class RegisterDuplicateTest {

    @Autowired
    MemberBasicController memberController;
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void duplicate_check() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberService.save(member);

        Assertions.assertThat(memberService.duplicate_check("test")).isEqualTo(false);

    }
}
