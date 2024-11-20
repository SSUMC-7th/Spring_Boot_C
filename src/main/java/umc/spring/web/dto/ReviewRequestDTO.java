package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewJoinDto {
        String title;
        String body;
        Float score;
    }
}
