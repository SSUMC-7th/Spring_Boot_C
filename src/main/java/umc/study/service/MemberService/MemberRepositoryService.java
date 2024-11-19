package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberRepositoryService {

    private final MemberRepository memberRepository;

    public boolean isInMemberRepository(Long memberId){
        return memberRepository.existsById(memberId);
    }
}
