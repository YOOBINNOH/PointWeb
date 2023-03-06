package project.PointWeb.MemberBasicTest;


import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import project.PointWeb.Domain.Member;
import project.PointWeb.Dto.MemberRegisterDto;
import project.PointWeb.Repository.MemberRepository;
import project.PointWeb.Controller.MemberController.MemberBasicController;
import project.PointWeb.Service.MemberBasicService;


@SpringBootTest
@Transactional
@Rollback
public class RegisterNameTest {

    @Autowired
    MemberBasicController memberController;
    @Autowired MemberRepository memberRepository;
    @Autowired
    MemberBasicService memberBasicService;

    @Test
    void duplicate_check() {

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(), memberRegisterDto.getTeamId(), null);
        memberBasicService.save(member);

        Assertions.assertThat(memberBasicService.isname_test_check("test")).isEqualTo(false);

    }
}
