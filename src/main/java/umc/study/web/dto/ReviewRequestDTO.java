package umc.study.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class writeReviewDTO{
        Long memberId;
        Long storeId;
        Float score;
        String reviewContent;
    }
}
