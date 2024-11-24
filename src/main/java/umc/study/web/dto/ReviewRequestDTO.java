package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistMembers;
import umc.study.validation.annotation.ExistStores;

import java.time.LocalDate;
import java.util.List;

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
