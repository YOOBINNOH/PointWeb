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

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback
class RegisterBasicTest {

    @Autowired
    MemberBasicController memberController;
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void 회원가입_저장_테스트() {

        // given

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        // when
        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(),memberRegisterDto.getTeamId(),null);
        memberService.save(member);
        //then

        Optional<Member> result = memberRepository.findBymemberId("test");

        // 회원 존재 여부 체크

        Assertions.assertThat(result.isPresent()).isEqualTo(true);

    }

    @Test
    void 회원가입_기본_포인트_테스트() {

        // given

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        // when
        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(),memberRegisterDto.getTeamId(),null);
        memberService.save(member);
        //then
        Optional<Member> result = memberRepository.findBymemberId("test");

        // then

        try{
            Long point = result.get().getCurrent_point();
            Assertions.assertThat(point).isEqualTo(1000);
        }
        catch (Exception e){

            // 회원가입 실패 시 예외 처리
            e.printStackTrace();
        }

    }

    @Test
    void 회원가입_기부_포인트_테스트() {

        // given

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        // when
        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(),memberRegisterDto.getTeamId(),null);
        memberService.save(member);
        //then
        Optional<Member> result = memberRepository.findBymemberId("test");

        // then

        try{
            Long point = result.get().getGive_point();
            Assertions.assertThat(point).isEqualTo(0);
        }
        catch (Exception e){

            // 회원가입 실패 시 예외 처리
            e.printStackTrace();
        }


    }

    @Test
    void 회원가입_팀가입_테스트() {

        // given

        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setMemberId("test");
        memberRegisterDto.setMemberPw(1234L);
        memberRegisterDto.setTeamId(1L);

        // when
        Member member = new Member(memberRegisterDto.getMemberId(), memberRegisterDto.getMemberPw(),memberRegisterDto.getTeamId(),null);
        memberService.save(member);
        //then
        Optional<Member> result = memberRepository.findBymemberId("test");

        // then

        try{
            Long team = result.get().getTeamId();
            Assertions.assertThat(team).isEqualTo(1L);
        }
        catch (Exception e){

            // 회원가입 실패 시 예외 처리
            e.printStackTrace();
        }


    }
/*
    @Test
    void 회원가입일자_생성_테스트() {

        //given

        MemberRegisterDto member = new MemberRegisterDto();
        member.setMemberId("test");
        member.setMemberPw(1234L);
        member.setTeamId(1L);



        //when
        memberController.register_check(member, null);
        Optional<Member> result = memberRepository.findBymemberId("test");

        // then

        LocalDateTime date = null;

        try{
            date = result.get().getRegister_date();

        }
        catch (Exception e){

            // 회원가입 실패 시 예외 처리
            e.printStackTrace();
        }

        Assertions.assertThat(date).isNotNull();


    }


*/

}