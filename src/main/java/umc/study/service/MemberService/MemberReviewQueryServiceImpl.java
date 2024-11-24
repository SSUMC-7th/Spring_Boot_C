package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MemberReviewQueryServiceImpl implements MemberReviewQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;


    @Override
    public Page<Review> getReviewList(Long MemberId, Integer page) {

        Member member = memberRepository.findById(MemberId).get();

        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberPage;
    }
}
