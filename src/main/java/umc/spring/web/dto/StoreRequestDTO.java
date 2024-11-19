package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        Long regionId;
        @NotBlank
        String address;
    }
}
