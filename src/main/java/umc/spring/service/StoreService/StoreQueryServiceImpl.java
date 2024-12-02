package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        if (page == null || page < 0) {
            throw new IllegalArgumentException(ErrorStatus.PAGE_NOT_EXIST.getMessage());
        }

        Store store = storeRepository.findById(StoreId).orElseThrow(() -> new IllegalArgumentException("해당 가게를 찾을 수 없습니다. storeId: " + StoreId));

        Page<Review> StoreReviewPage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StoreReviewPage;
    }

    @Override
    public Page<Mission> getStoreMissionList(Long StoreId, Integer page) {
        if (page == null || page < 0) {
            throw new IllegalArgumentException(ErrorStatus.PAGE_NOT_EXIST.getMessage());
        }

        Store store = storeRepository.findById(StoreId).orElseThrow(() -> new IllegalArgumentException("해당 가게를 찾을 수 없습니다. storeId: " + StoreId));

        Page<Mission> StoreMissionPage = missionRepository.findAllByStore(store, PageRequest.of(page-1, 10));
        return StoreMissionPage;
    }
}
