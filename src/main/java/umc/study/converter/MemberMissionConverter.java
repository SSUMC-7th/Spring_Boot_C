package umc.study.converter;

import umc.study.domain.*;

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
}
