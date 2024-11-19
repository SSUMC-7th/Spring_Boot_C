package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDto{
        String title;
        String Body;
        Float Score;
    }
}
