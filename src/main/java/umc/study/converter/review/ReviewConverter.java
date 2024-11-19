package umc.study.converter.review;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

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
}
