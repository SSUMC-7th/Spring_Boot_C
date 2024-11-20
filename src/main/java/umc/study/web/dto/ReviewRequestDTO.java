package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.study.validation.annotation.ExistMembers;
import umc.study.validation.annotation.ExistStores;

public class ReviewRequestDTO {

    @Getter
    public static class writeReviewDTO{
        @ExistMembers
        Long memberId;
        @ExistStores
        Long storeId;
        @NotBlank
        Float score;
        @NotBlank
        String reviewContent;
    }
}
