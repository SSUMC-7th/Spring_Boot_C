package umc.spring.service.MissionService;

import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.apiPayoad.exception.handler.MemberHandler;
import umc.spring.apiPayoad.exception.handler.MissionHandler;
import umc.spring.apiPayoad.exception.handler.TempHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final LocalContainerEntityManagerFactoryBean entityManagerFactory;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public MemberMission addMemberMission(MissionRequestDTO.MissionJoinDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMission(request, member, mission);

        return memberMissionRepository.save(newMemberMission);
    }

    @Override
    @Transactional
    public MemberMission updateMemberMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.updateStatus(memberMission);
        return memberMissionRepository.save(newMemberMission);

    }
}
