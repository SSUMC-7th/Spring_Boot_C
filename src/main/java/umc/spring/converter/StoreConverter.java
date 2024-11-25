package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.ReviewPrivewDTO reviewPrivewDTO(Review review) {
        return StoreResponseDTO.ReviewPrivewDTO.builder()
                .nickname(review.getMember().getName())
                .score(review.getScore())
                .content(review.getTitle())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPrivewDTO> reviewPrivewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPrivewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .listSize(reviewList.getNumber())
                .totalElements(reviewList.getTotalElements())
                .totalPage(reviewList.getTotalPages())
                .reviewList(reviewPrivewDTOList)
                .build();
    }
}
