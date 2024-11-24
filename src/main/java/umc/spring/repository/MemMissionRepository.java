package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;

public interface MemMissionRepository extends JpaRepository<MemberMission, Long> {

    public boolean existsByMissionId(Long missionId);

    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}
