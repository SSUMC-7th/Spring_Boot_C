package umc.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // memberId와 missionId의 조합으로 존재 여부 확인
    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);
}

