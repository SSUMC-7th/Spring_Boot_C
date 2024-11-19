package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review joinReview(ReviewRequestDTO.JoinDto request) {
        // DB에서 임의의 멤버와 상점을 가져오기
        Member member = memberRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No member found in the database"));
        Store store = storeRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No store found in the database"));

        // 리뷰 생성
        Review newReview = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(newReview);
    }
}

