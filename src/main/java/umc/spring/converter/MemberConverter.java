package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberPrefer;
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

        Gender gender=null;
        switch(request.getGender()){
            case 1:
                gender=Gender.MALE;
                break;
            case 2:
                gender=Gender.FEMALE;
                break;
            case 3:
                gender=Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())
                .password(request.getPassword())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .age(request.getAge())
                .role(request.getRole())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.ReviewPreviewDTO toreviewPreviewDTO(Review review){
        return MemberResponseDTO.ReviewPreviewDTO.builder()
                .ownNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.ReviewPreviewListDTO toreviewPreviewListDTO(Page<Review> reviewList){
        List<MemberResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList= reviewList.stream()
                .map(MemberConverter::toreviewPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreviewListDTO.builder()
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewPreviewList(reviewPreviewDTOList)
                .build();
    }

}
