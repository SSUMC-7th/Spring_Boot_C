package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review writeReview(ReviewRequestDTO.writeReviewDTO request);
}
