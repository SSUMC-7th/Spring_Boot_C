package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreMissionRequestDTO {

    @Getter
    public static class StoreMissionJoinDTO {
        @NotNull
        Long storeId;

        @Size(min = 1, max = 50)
        String missionSpec;

        @NotNull
        Integer reward;
    }
}
