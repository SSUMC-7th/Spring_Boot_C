package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final StoreConverter storeConverter;

    @Override
    public Store addStore(StoreRequestDTO.StoreRegisterDTO request) {
        Store newStore=storeConverter.toStore(request);

        return storeRepository.save(newStore);
    }
}
