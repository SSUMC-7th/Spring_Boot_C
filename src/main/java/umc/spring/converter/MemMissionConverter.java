package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemMissionRequestDTO;
import umc.spring.web.dto.MemMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemMissionConverter {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public static MemMissionResponseDTO.RegisterChallengingResultDTO registerChallengingResultDTO(MemberMission memberMission) {
        return MemMissionResponseDTO.RegisterChallengingResultDTO.builder()
                .memMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public MemberMission toMemberMission(MemMissionRequestDTO.RegisterChallengingDTO request) {

        Member member=memberRepository.findById(request.getMemberId()).orElse(null);
        Mission mission=missionRepository.findById(request.getMissionId()).orElse(null);

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemMissionResponseDTO.ChallengingMissionDTO toChallengingMissionDTO(MemberMission memMission) {
        return MemMissionResponseDTO.ChallengingMissionDTO.builder()
                .storeName(memMission.getMission().getStore().getName())
                .missionSpec(memMission.getMission().getMissionSpec())
                .build();
    }

    public static MemMissionResponseDTO.ChallengingMissionListDTO toChallengingMissionListDTO(Page<MemberMission> memMissionList) {
        List<MemMissionResponseDTO.ChallengingMissionDTO> memMissionDTOList = memMissionList.stream()
                .map(MemMissionConverter::toChallengingMissionDTO).collect(Collectors.toList());

        return MemMissionResponseDTO.ChallengingMissionListDTO.builder()
                .isFirst(memMissionList.isFirst())
                .isLast(memMissionList.isLast())
                .totalPage(memMissionList.getTotalPages())
                .totalElements(memMissionList.getTotalElements())
                .listSize(memMissionDTOList.size())
                .reviewList(memMissionDTOList)
                .build();
    }
}
