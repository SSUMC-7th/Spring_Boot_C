package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.converter.review.ReviewConverter;
import umc.study.domain.*;
import umc.study.web.dto.MyMissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static List<MemberMission> toMemberMissionList(Member member, List<Mission> missionList) {

        return missionList.stream()
                .map(mission ->
                        MemberMission.builder()
                                .member(member)
                                .mission(mission)
                                .build()
                ).collect(Collectors.toList());
    }

    public static MyMissionResponseDTO.challengeResultDTO toMyMissionResponseDTO(List<MemberMission> memberMissions) {
        List<Long> memberMissionId = memberMissions.stream()
                .map(MemberMission::getId)
                .toList();

        return MyMissionResponseDTO.challengeResultDTO.builder()
                .createdAt(LocalDateTime.now())
                .createdMyMissions(memberMissionId)
                .build();
    }

    public static MyMissionResponseDTO.MyMissionPreviewDTO myMissionPreviewDTO(MemberMission memberMission) {
        return MyMissionResponseDTO.MyMissionPreviewDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .spec(memberMission.getMission().getMissionSpec())
                .build();
    }

    public static MyMissionResponseDTO.MyMissionPreviewListDTO myMissionPreViewListDTO(Page<MemberMission> memberMissionPage) {
        List<MyMissionResponseDTO.MyMissionPreviewDTO> myMissionPreViewDTOList = memberMissionPage.stream()
                .map(MemberMissionConverter::myMissionPreviewDTO).collect(Collectors.toList());

        return MyMissionResponseDTO.MyMissionPreviewListDTO.builder()
                .isLast(memberMissionPage.isLast())
                .isFirst(memberMissionPage.isFirst())
                .totalPage(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .listSize(myMissionPreViewDTOList.size())
                .reviewList(myMissionPreViewDTOList)
                .build();
    }
}
