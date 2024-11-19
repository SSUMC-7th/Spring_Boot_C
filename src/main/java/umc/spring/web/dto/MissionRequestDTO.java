package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class MissionJoinDto{
        @NotNull
        Integer status;
    }
}
