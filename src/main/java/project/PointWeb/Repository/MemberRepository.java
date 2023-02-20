package project.PointWeb.Repository;

import project.PointWeb.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository <Member, Long> {

}
