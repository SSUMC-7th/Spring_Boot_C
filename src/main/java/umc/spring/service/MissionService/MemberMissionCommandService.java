package umc.spring.service.MissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MemberMissionCommandService {

    MemberMission addMemberMission(MissionRequestDTO.MissionJoinDTO request);
    MemberMission updateMemberMission(Long memberMissionId);
}
