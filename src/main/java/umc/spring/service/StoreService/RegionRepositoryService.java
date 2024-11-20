package umc.spring.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.RegionRepository;

@Service
@RequiredArgsConstructor
public class RegionRepositoryService {

    private final RegionRepository regionRepository;

    public boolean isInRegionRepository(Long regionId){
        return regionRepository.existsById(regionId);
    }
}
