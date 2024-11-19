package umc.study.converter;

import umc.study.domain.*;
import umc.study.web.dto.MyMissionResponseDTO;

import java.time.LocalDateTime;
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

    public static MyMissionResponseDTO.challengeResultDTO toMyMissionResponseDTO(List<MemberMission> memberMissions){
        List<Long> memberMissionId = memberMissions.stream()
                .map(MemberMission::getId)
                .toList();

        return MyMissionResponseDTO.challengeResultDTO.builder()
                .createdAt(LocalDateTime.now())
                .createdMyMissions(memberMissionId)
                .build();
    }
}
