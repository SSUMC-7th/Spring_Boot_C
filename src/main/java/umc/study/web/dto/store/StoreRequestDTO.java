package umc.study.web.dto.store;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.study.validation.annotation.ExistRegions;

public class StoreRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @ExistRegions
        Long regionId;
        @NotBlank
        String address;
    }
}
