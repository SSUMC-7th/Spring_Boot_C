package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinMemberResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinMemberResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinMemberDTO request) {
        Gender gender= null;

        switch (request.getGender()) {
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
                .age(request.getBirthYear())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MemberMissionDTO toMemberMissionDTO(MemberMission memberMission) {
        return MemberResponseDTO.MemberMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .newStatus("COMPLETE")
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
