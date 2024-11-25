package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface StoreReviewQueryService {

    Page<Review> getReviewList(Long storeId, Integer page);
}
