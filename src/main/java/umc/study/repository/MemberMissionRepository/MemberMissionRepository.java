package umc.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}

