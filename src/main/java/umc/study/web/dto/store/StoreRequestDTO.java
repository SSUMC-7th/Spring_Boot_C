package umc.study.web.dto.store;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotBlank
        Long regionId;
        @NotBlank
        String address;
    }
}
