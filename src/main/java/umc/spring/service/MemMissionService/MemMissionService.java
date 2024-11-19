package umc.spring.service.MemMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemMissionRequestDTO;

public interface MemMissionService {
    public MemberMission addMemMission(MemMissionRequestDTO.RegisterChallengingDTO request);
}
