package Service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.PointWeb.Domain.Member;
import project.PointWeb.Repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
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

}
