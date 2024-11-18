package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member member= MemberConverter.toMember(request);

        return null;
    }
}
