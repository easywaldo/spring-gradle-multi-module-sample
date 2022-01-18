package domain.member.repository;

import domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "member-repository")
public interface MemberRepository extends JpaRepository<Member, Long> {
}
