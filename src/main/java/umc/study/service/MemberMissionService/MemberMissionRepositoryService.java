package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionRepositoryService {

    private final MemberMissionRepository memberMissionRepository;

    public boolean checkChallenging(Long memberId, List<Long> missionIdList) {
        // missionIdList를 스트림으로 처리하여, 존재하는 조합이 있으면 false 반환
        return missionIdList.stream()
                .noneMatch(missionId -> memberMissionRepository.existsByMember_IdAndMission_Id(memberId, missionId));
    }
}
