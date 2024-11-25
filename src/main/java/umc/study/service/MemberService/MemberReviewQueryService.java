package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface MemberReviewQueryService {

    Page<Review> getReviewList(Long MemberId, Integer page);
}
