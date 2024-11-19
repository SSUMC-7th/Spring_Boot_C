package umc.study.web.dto;

import umc.study.domain.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

public class MyMissionResponseDTO {
    public static class challengeResultDTO{
        Long memberId;
        List<Long> createdMyMissions;
        LocalDateTime createdAt;
    }
}
