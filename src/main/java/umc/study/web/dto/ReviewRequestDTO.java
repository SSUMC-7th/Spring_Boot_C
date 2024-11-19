package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class writeReviewDTO{
        @NotBlank
        Long memberId;
        @NotBlank
        Long storeId;
        @NotBlank
        Float score;
        @NotBlank
        String reviewContent;
    }
}
