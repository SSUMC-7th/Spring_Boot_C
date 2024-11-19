package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.IsChallenging;

public class MissionRequestDTO {

    @Getter
    public static class MissionJoinDTO {
        @IsChallenging
        Long memberId;

        @NotNull
        Long missionId;
    }
}
