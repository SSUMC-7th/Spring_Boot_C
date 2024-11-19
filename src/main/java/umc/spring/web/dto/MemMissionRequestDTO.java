package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.AlreadyChallenging;

public class MemMissionRequestDTO {

    @Getter
    public static class RegisterChallengingDTO{

        @AlreadyChallenging
        Long missionId;
        @NotNull
        Long memberId;
    }
}
