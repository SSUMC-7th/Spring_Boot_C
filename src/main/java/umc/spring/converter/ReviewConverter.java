package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

@Component //스프링이 memberRepository 필드에 주입해주기 위해 어노테이션 추가
@RequiredArgsConstructor
public class ReviewConverter {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDto(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .body(review.getBody())
                .name(review.getMember().getName())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Review toReview(ReviewRequestDTO.reviewDto request){ //repository 의존성 때문에 static 삭제

        Member member = memberRepository.findByName(request.getName()).orElseThrow(()->new RuntimeException("member를 찾을 수 없음"));
        Store store = storeRepository.findByName(request.getStoreName()).orElseThrow(()->new RuntimeException("store을 찾을 수 없음"));
        return Review.builder()
                .body(request.getBody())
                .member(member)
                .score(request.getScore())
                .store(store)
                .build();
    }
}
