package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class StoreConverter {

    private final RegionRepository regionRepository;

    public static StoreResponseDTO.StoreRegisterResultDTO toStoreRegisterResult(Store store) {
        return StoreResponseDTO.StoreRegisterResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Store toStore(StoreRequestDTO.StoreRegisterDTO request){

        Region region=regionRepository.findById(request.getRegionId()).get();

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
