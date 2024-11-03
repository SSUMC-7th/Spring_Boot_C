package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //1. 메서드 이름으로 쿼리 생성
    //List<Member> findByNameAndStatus(String name, MemberStatus status);

    //2. @Query 어노테이션
    @Query("SELECT m FROM Member m WHERE m.name=:name AND m.status=:status")
    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);

}
