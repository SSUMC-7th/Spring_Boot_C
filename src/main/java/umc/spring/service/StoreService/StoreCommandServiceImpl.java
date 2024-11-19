package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.ApiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDTO request) {
        Long regionId = request.getRegionId();
        Region storeRegion = regionRepository.findById(regionId).orElseThrow(()->new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = StoreConverter.toStore(request,storeRegion);
        return storeRepository.save(store);
    }
}
