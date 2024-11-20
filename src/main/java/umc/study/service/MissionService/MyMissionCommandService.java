package umc.study.service.MissionService;

import umc.study.domain.MemberMission;
import umc.study.web.dto.MyMissionRequestDTO;

import java.util.List;

public interface MyMissionCommandService {
    List<MemberMission> makeMyMission(MyMissionRequestDTO.challengeDTO request);
}
