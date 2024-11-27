package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class StoreMissionDTO {
        String storeName;
        String missionSpec;
        Integer reward;
        LocalDateTime createdAt;
    }

    public static class ReviewPrivewDTO {
        String nickname;
        Float score;
        String content;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionListDTO {
        List<StoreMissionDTO> storeMissionList;
        Long totalElements;
        Integer listSize;
        Integer totalPage;
        Boolean isFirst;
        Boolean isLast;
    }

    public static class ReviewPreviewListDTO {
        List<ReviewPrivewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
