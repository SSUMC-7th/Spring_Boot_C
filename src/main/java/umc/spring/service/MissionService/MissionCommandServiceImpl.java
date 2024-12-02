package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission joinMission(MissionRequestDTO.MissionJoinDto request) {
        // 임의의 회원과 미션 조회 및 로직 실행
        Member member = memberRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No member found in the database"));

        Mission mission = missionRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No mission found in the database"));

        // 중복 확인 생략
        MemberMission memberMission = MissionConverter.toMemberMission(mission, member, request.getStatus());

        // 데이터 저장
        return memberMissionRepository.save(memberMission);
    }

}

