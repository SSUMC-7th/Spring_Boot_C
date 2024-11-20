package umc.spring.service.StoreMissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreMissionRequestDTO;

public interface StoreMissionCommandService {
    Mission joinMission(StoreMissionRequestDTO.StoreMissionJoinDTO request);
}
