package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    // 제공할 기능을 여기서 선언
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, float score);

    Page<Review> getReviewList(Long storeid, Integer page);
}
