package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.StoreMissionDTO storeMissionDTO(Mission mission) {
        return StoreResponseDTO.StoreMissionDTO.builder()
                .storeName(mission.getStore().getName())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListDTO storeMissionListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.StoreMissionDTO> storeMissionDTOList = missionList.stream()
                .map(StoreConverter::storeMissionDTO).collect(Collectors.toList());

        return StoreResponseDTO.StoreMissionListDTO.builder()
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .storeMissionList(storeMissionDTOList)
                .build();
    }
}
