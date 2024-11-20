package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistMemberMission;

import java.util.List;

public class MyMissionRequestDTO {

    @Getter
    @ExistMemberMission
    public static class challengeDTO{
        Long memberId;
        List<Long> challengeMissions;
    }
}
