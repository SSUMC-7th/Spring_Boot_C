package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.MemberMission;
import umc.study.domain.Mission;
import umc.study.domain.Review;

public interface MyMissionQueryService {

    Page<MemberMission> getMissionList(Long MemberId, Integer page);
}
