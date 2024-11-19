package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review joinReview(ReviewRequestDTO.JoinDto request) {

        Review newReview = ReviewConverter.toReview(request);

        return reviewRepository.save(newReview);
    }
}

