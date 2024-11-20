package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;

public interface MemMissionRepository extends JpaRepository<MemberMission, Long> {

    public boolean existsByMissionId(Long missionId);
}
