package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreMissionRequestDTO;
import umc.spring.web.dto.StoreMissionResponseDTO;

import java.time.LocalDateTime;

public class StoreMissionConverter {

    public static StoreMissionResponseDTO.StoreMissionJoinResultDTO toStoreMissionJoinResultDTO (Mission mission) {
        return StoreMissionResponseDTO.StoreMissionJoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission (StoreMissionRequestDTO.StoreMissionJoinDTO request, Store store) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .store(store)
                .build();
    }
}
