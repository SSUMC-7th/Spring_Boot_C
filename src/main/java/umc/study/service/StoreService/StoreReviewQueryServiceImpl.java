package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreReviewQueryServiceImpl implements StoreReviewQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page - 1, 10));
        return storePage;
    }
}
