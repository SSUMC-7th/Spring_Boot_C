package umc.spring.service.MissionService;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Member joinMission(MissionRequestDTO.MissionJoinDto request);
}
