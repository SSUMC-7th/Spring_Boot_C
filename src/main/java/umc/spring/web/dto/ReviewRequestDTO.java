package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewJoinDTO {
        Long memberId;
        Long storeId;
        String title;
        Float score;
    }
}
