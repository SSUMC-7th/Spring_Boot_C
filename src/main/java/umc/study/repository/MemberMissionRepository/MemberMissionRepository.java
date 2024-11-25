package umc.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.MemberMission;
import umc.study.domain.Review;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // memberId와 missionId의 조합으로 존재 여부 확인
    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);

    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}

