package umc.spring.service.StoreMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.apiPayoad.exception.handler.StoreHandler;
import umc.spring.converter.StoreMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreMissionCommandServiceImpl implements StoreMissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission joinMission(StoreMissionRequestDTO.StoreMissionJoinDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_CATEGORY_NOT_FOUND));

        Mission newMission = StoreMissionConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }
}
