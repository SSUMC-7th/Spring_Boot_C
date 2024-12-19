    package umc.spring.service.MemberService;

    import jakarta.transaction.Transactional;
    import lombok.RequiredArgsConstructor;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;
    import umc.spring.ApiPayload.code.status.ErrorStatus;
    import umc.spring.ApiPayload.exception.handler.FoodCategoryHandler;
    import umc.spring.converter.MemberConverter;
    import umc.spring.converter.MemberPreferConverter;
    import umc.spring.domain.FoodCategory;
    import umc.spring.domain.Member;
    import umc.spring.domain.Review;
    import umc.spring.domain.mapping.MemberPrefer;
    import umc.spring.repository.FoodCategoryRepository;
    import umc.spring.repository.MemberRepository;
    import umc.spring.repository.ReviewRepository;
    import umc.spring.web.dto.MemberRequestDTO;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    @RequiredArgsConstructor
    public class MemberCommandServiceImpl implements MemberCommandService{

        private final MemberRepository memberRepository;

        private final ReviewRepository reviewRepository;

        private final FoodCategoryRepository foodCategoryRepository;

        private final PasswordEncoder passwordEncoder;


        @Override
        @Transactional
        public Member joinMember(MemberRequestDTO.JoinDto request) {
            System.out.println("선호 카테고리: " + request.getPreferCategory());

            Member newMember = MemberConverter.toMember(request);
            newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
            List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                    .map(category -> {
                        return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                    }).collect(Collectors.toList());

            List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

            memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

            return memberRepository.save(newMember);
        }
        @Override
        public Page<Review> getMemberReviewList(Long memberId, Integer page) {
            Member member = memberRepository.findById(memberId).get();

            Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page-1, 10));
            return MemberPage;
        }
    }

