package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Page<MemberMission> getMissionList(Long MemberId, Integer page) {

        Member member = memberRepository.findById(MemberId).get();

        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page-1, 10));

        return memberMissionPage;
    }
}
