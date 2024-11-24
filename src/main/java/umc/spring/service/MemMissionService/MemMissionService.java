package umc.spring.service.MemMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemMissionRequestDTO;

public interface MemMissionService {
    public MemberMission addMemMission(MemMissionRequestDTO.RegisterChallengingDTO request);
    Page<MemberMission> getMemMissionList(Long memberId, Integer page);
    Integer checkPage(Integer page);
}
