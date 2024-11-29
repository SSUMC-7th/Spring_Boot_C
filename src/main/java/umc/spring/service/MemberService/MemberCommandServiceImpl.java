package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.apiPayoad.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinMemberDTO request) {

        // converter의 toMember 함수를 통해 새로운 Member 객체 생성
        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));    // 비번 암호화

        // request에 들어있는 food category 배열에서 하나씩 꺼내며 foodCategoryRepository에 있는지 검사.
        // 없으면 orElseThrow 함수를 타고 에러 핸들러로 가고,
        // 있다면 계속 반복 후 collect 함수를 통해 foodCategoriesList에 저장된다.
        List<FoodCategory> foodCategoriesList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        // foodCategoriesList를 memberPerferList로 변환 by converter
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoriesList);

        // memberPrefer 테이블에 newMember와 memberPreferList 내용 저장한다.
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        // newMember 객체를 memberRepository에 저장.
        return memberRepository.save(newMember);
    }
}
