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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewPreviewListDTO {
        List<MyReviewPreviewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewPreviewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
