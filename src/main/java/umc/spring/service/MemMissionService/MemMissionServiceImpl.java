package umc.spring.service.MemMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemMissionConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemMissionServiceImpl implements MemMissionService {

    private final MemMissionRepository memMissionRepository;
    private final MemberRepository memberRepository;
    private final MemMissionConverter memMissionConverter;

    @Override
    @Transactional
    public MemberMission addMemMission(MemMissionRequestDTO.RegisterChallengingDTO request) {

        MemberMission memberMission= memMissionConverter.toMemberMission(request);

        return memMissionRepository.save(memberMission);
    }

    @Override
    public Page<MemberMission> getMemMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> memMisisonPage = memMissionRepository.findAllByMember(member, PageRequest.of(page, 10));

        return memMisisonPage;
    }

    @Override
    public Integer checkPage(Integer page) {
        return page-1;
    }


}
