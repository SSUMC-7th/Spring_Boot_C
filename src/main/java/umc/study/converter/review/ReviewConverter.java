package umc.study.converter.review;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.reviewResultDTO toJoinResultDTO(Review review){
        return ReviewResponseDTO.reviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.writeReviewDTO request, Member writerMember, Store writtenStore){

        return Review.builder()
                .member(writerMember)
                .score(request.getScore())
                .store(writtenStore)
                .body(request.getReviewContent())
                .build();
    }

    public static ReviewResponseDTO.MyReviewPreviewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.MyReviewPreviewDTO.builder()
                .myNickName(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.MyReviewPreviewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.MyReviewPreviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
