package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegions;

public class StoreRequestDTO {

    @Getter
    public static class StoreRegisterDTO{

        @NotBlank
        String name;
        @NotBlank
        String address;
        @ExistRegions
        Long regionId;
    }
}
