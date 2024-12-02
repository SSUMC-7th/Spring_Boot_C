package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static List<MemberMission> toMemberMissionList(Member member, List<Mission> missionList){
        return missionList.stream()
                .map(mission ->
                        MemberMission.builder()
                                .member(member)
                                .mission(mission)
                                .build()
                        ).collect(Collectors.toList());
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO memberMissionPreViewDTO(Mission memberMission){
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .storeName(memberMission.getStore().getName())
                .reward(memberMission.getReward())
                .missionSpec(memberMission.getMissionSpec())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewListDTO memberMissionPreViewListDTO(Page<MemberMission> memberMissionList){

        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionPreViewDTOList = memberMissionList.stream()
                .map(memberMission -> MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                        .missionSpec(memberMission.getMission().getMissionSpec()) // MissionSpec 가져오기
                        .status(memberMission.getStatus().toString()) // Status 변환
                        .reward(memberMission.getMission().getReward()) // Reward 가져오기
                        .storeName(memberMission.getMission().getStore().getName()) // Store 이름 가져오기
                        .build())
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreviewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .memberMissionList(memberMissionPreViewDTOList)
                .build();
    }
}
