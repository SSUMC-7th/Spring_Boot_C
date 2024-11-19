package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionRepositoryService {

    private final MissionRepository missionRepository;

    public boolean isInMissionRepository(Long missionId) {
        return missionRepository.existsById(missionId);
    }
}
