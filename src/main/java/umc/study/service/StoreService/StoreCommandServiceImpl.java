package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    @Override
    public Store joinMember(StoreRequestDTO.JoinDTO request) {

        return null;
    }
}
