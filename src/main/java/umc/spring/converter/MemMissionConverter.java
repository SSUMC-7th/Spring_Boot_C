package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemMissionRequestDTO;
import umc.spring.web.dto.MemMissionResponseDTO;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MemMissionConverter {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public static MemMissionResponseDTO.RegisterChallengingResultDTO registerChallengingResultDTO(MemberMission memberMission) {
        return MemMissionResponseDTO.RegisterChallengingResultDTO.builder()
                .memMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public MemberMission toMemberMission(MemMissionRequestDTO.RegisterChallengingDTO request) {

        Member member=memberRepository.findById(request.getMemberId()).orElse(null);
        Mission mission=missionRepository.findById(request.getMissionId()).orElse(null);

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
