package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

import static umc.spring.apiPayload.code.status.ErrorStatus.MEMBER_NOT_FOUND;
import static umc.spring.apiPayload.code.status.ErrorStatus.STORE_NOT_FOUND;

@Component //스프링이 memberRepository 필드에 주입해주기 위해 어노테이션 추가
@RequiredArgsConstructor
public class ReviewConverter {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDto(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .body(review.getBody())
                .memberId(review.getMember().getId())
                .score(review.getScore())
                .storeId(review.getStore().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Review toReview(ReviewRequestDTO.reviewDto request){ //repository 의존성 때문에 static 삭제

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()->new MemberHandler(MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(STORE_NOT_FOUND));
        return Review.builder()
                .body(request.getBody())
                .member(member)
                .score(request.getScore())
                .store(store)
                .build();
    }
}
