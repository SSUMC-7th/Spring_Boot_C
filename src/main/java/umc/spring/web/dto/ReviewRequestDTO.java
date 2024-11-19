package umc.spring.web.dto;


import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class reviewDto{
        String body;
        String name;
        Float score;
        String storeName;
    }
}
