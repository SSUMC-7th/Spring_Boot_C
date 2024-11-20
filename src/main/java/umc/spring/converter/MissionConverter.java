package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    // MissionResponseDTO 변환
    public static MissionResponseDTO.MissionResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // MissionStatus Enum -> Integer 변환
    public static Integer toIntegerStatus(MissionStatus status) {
        switch (status) {
            case CHALLENGING:
                return 1;
            case COMPLETED:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown MissionStatus: " + status);
        }
    }

    // Integer -> MissionStatus Enum 변환
    public static MissionStatus toEnumStatus(Integer status) {
        switch (status) {
            case 1:
                return MissionStatus.CHALLENGING;
            case 2:
                return MissionStatus.COMPLETED;
            default:
                throw new IllegalArgumentException("Unknown status value: " + status);
        }
    }

    // MemberMission 생성
    public static MemberMission toMemberMission(Mission mission, Member member, Integer status) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(toEnumStatus(status)) // Integer를 Enum으로 변환하여 설정
                .build();
    }
}
