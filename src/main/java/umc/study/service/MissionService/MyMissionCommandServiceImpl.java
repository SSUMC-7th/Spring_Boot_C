package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayLoad.code.status.ErrorStatus;
import umc.study.apiPayLoad.exception.handler.MemberHandler;
import umc.study.apiPayLoad.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.MemberMission;
import umc.study.domain.Mission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.dto.MyMissionRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyMissionCommandServiceImpl implements MyMissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public List<MemberMission> makeMyMission(MyMissionRequestDTO.challengeDTO request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        List<Mission> missions = request.getChallengeMissions().stream()
                .map(mission -> {
                    return missionRepository.findById(mission).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_EXIST));
                }).toList();
        List<MemberMission> memberMissions = MemberMissionConverter.toMemberMissionList(member,missions);
        memberMissionRepository.saveAll(memberMissions);
        return memberMissions;
    }
}
