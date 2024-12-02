package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MemberReviewPreviewDTO memberReviewPreViewDTO(Review memberReview){
        return MemberResponseDTO.MemberReviewPreviewDTO.builder()
                .ownerNickname(memberReview.getMember().getName())
                .score(memberReview.getScore())
                .createdAt(memberReview.getCreatedAt().toLocalDate())
                .body(memberReview.getBody())
                .build();
    }

    public static MemberResponseDTO.MemberReviewPreviewListDTO memberReviewPreviewListDTO(Page<Review> memberReviewList){

        List<MemberResponseDTO.MemberReviewPreviewDTO> memberReviewPreViewDTOList = memberReviewList.stream()
                .map(MemberConverter::memberReviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberReviewPreviewListDTO.builder()
                .isLast(memberReviewList.isLast())
                .isFirst(memberReviewList.isFirst())
                .totalPage(memberReviewList.getTotalPages())
                .totalElements(memberReviewList.getTotalElements())
                .listSize(memberReviewPreViewDTOList.size())
                .memberReviewList(memberReviewPreViewDTOList)
                .build();

    }
}
