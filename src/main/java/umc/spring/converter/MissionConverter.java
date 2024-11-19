package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.MissionResultDTO toJoinResultDTO(Mission mission){
       return MissionResponseDTO.MissionResultDTO.builder()
               .missionId(mission.getId())
               .createdAt(LocalDateTime.now())
               .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionJoinDto request, Member member){
        return Mission.builder()
                .build();
    }
}
