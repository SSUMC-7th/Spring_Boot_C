package umc.study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;

public interface RegionRepository extends JpaRepository<Member, Long> {
}

