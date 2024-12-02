package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionCommandService {
    Page<MemberMission> getMissionList(Long MissionId, Integer page);
}
