package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository.MemberRepository;

import java.util.List;

public interface MemberQueryService{
    List<Member> findMember(Long memberId);
}
