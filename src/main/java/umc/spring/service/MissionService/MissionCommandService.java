package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    MemberMission joinMission(MissionRequestDTO.MissionJoinDto request);
}
