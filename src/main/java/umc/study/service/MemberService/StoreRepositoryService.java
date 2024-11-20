package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreRepositoryService {

    private final StoreRepository storeRepository;

    public boolean isInStoreRepository(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}
