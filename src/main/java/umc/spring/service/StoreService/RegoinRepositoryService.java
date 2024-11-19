package umc.spring.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionRepositoryService {

    private final RegionRepository regionRepository;

    public boolean isInRegionRepository(Long regionId){
        return regionRepository.existsById(regionId);
    }
}
