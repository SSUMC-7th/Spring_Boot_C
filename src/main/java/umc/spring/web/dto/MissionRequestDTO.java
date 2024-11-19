package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.AlreadyChallengingMission;

public class MissionRequestDTO {
    @Getter
    public static class MissionJoinDto{
        @NotNull
        @AlreadyChallengingMission
        Integer status;
    }
}
