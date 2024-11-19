package umc.spring.service.ReviewService;

import umc.spring.domain.Member;

import java.util.Optional;

public interface ReviewQueryService {

    Optional<Member> findMember(Long id);

}