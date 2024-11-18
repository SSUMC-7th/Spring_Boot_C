package umc.spring.repository.TempMemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom{
} //6주차에서 나 혼자 만들었던거
