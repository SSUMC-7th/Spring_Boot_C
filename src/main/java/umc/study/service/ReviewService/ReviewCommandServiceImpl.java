package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;

    @Override
    public Review writeReview(ReviewRequestDTO.writeReviewDTO request) {

        return null;
    }
}
