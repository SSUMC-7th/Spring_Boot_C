package umc.spring.web.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistStores;

public class ReviewRequestDTO {

    @Getter
    public static class reviewDto{
        @Size(min=5, max=12)
        String body;
        @ExistMembers
        Long memberId;
        @NotNull
        Float score;
        @ExistStores
        Long storeId;
    }
}
