package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final StoreConverter storeConverter;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Store addStore(StoreRequestDTO.StoreRegisterDTO request) {
        Store newStore=storeConverter.toStore(request);

        return storeRepository.save(newStore);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));

        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();
        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));

        return missionPage;
    }

    @Override
    public Integer pageCheck(Integer page) {
        return page-1;
    }
}
