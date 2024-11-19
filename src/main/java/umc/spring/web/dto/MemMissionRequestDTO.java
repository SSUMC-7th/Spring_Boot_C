package umc.spring.web.dto;

import lombok.Getter;

public class MemMissionRequestDTO {

    @Getter
    public static class RegisterChallengingDTO{
        Long missionId;
        Long memberId;
    }
}
