package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.apiPayoad.exception.handler.ReviewHandler;
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

    // SQL 연결
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    // Review 객체 생성
    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.ReviewJoinDTO request) {
        // member 테이블에서 맨 앞의 개체 가져오기.
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.STORE_NOT_FOUND));
        
        // request를 Review 객체로 변환 및 reviewRepository에 저장
        Review newReview = ReviewConverter.toReview(request, member, store);

        return reviewRepository.save(newReview);
    }
}
