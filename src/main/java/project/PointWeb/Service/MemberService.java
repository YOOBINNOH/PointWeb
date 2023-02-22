package project.PointWeb.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.PointWeb.Domain.Member;
import project.PointWeb.Repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    final MemberRepository memberRepository;

    // 저장 기능
    public Long save(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    // 탈퇴 기능
    public Long delete(Member member){
        memberRepository.delete(member);
        return member.getId();
    }

    // 로그인 체크
    @Transactional
    public boolean login_check(String loginId, Long loginPw, LocalDateTime login_date){

        Optional<Member> findmember =  memberRepository.findBymemberId(loginId);

        if ( findmember.isPresent() == true ){
            if (findmember.get().getMemberPw().equals(loginPw)){

                Member member = memberRepository.findByid(findmember.get().getId());
                member.update_Login_date(login_date);
                member.update_current_point();
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }

    }

    // ID 중복 체크 기능
    public boolean duplicate_check(String check_id){

        if (memberRepository.findBymemberId(check_id).isPresent()){
            return false;
        }
        else{
            return true;
        }
    }

    // ID가 "test" 인지 여부 체크
    public boolean isname_test_check(String check_id){

        if (check_id.equals("test")){
            return false;
        }
        else{
            return true;
        }
    }

}