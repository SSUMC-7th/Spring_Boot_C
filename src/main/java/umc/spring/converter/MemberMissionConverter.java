package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequiredArgsConstructor
public class MemberMissionConverter {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    public static MissionResponseDTO.MissionJoinResultDTO toMissionJoinResultDTO(MemberMission memberMission) {
        return MissionResponseDTO.MissionJoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMission(MissionRequestDTO.MissionJoinDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .id(request.getMissionId())
                .status(MissionStatus.CHALLENGING)
                .mission(mission)
                .member(member)
                .build();
    }

    public static MemberMission updateStatus(MemberMission memberMission) {
        return MemberMission.builder()
                .id(memberMission.getId())
                .status(MissionStatus.COMPLETE)
                .member(memberMission.getMember())
                .mission(memberMission.getMission())
                .build();
    }
}
