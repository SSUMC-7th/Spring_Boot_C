package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayLoad.code.status.ErrorStatus;
import umc.study.apiPayLoad.exception.handler.RegionHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.Member;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.store.StoreRequestDTO;

import java.util.Optional;


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
