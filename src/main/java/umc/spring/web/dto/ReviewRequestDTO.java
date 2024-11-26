package umc.spring.web.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistStores;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewJoinDto {
        String title;
        @Size(min = 5, max = 12)
        String body;
        Float score;
        @ExistMembers
        Long memberId;
        @ExistStores
        Long storeId;
    }
}
