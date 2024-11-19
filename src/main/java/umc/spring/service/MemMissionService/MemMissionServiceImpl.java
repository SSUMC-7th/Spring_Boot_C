package umc.spring.service.MemMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemMissionConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemMissionServiceImpl implements MemMissionService {

    private final MemMissionRepository memMissionRepository;
    private final MemMissionConverter memMissionConverter;

    @Override
    @Transactional
    public MemberMission addMemMission(MemMissionRequestDTO.RegisterChallengingDTO request) {

        MemberMission memberMission= memMissionConverter.toMemberMission(request);

        return memMissionRepository.save(memberMission);
    }
}
