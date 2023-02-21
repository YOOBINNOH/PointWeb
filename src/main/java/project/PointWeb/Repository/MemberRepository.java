package project.PointWeb.Repository;

import project.PointWeb.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository <Member, Long> {

      Optional<Member> findBymemberId(String memberId);

      Member findByid(Long id);
}
