package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayoad.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MemberMissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionJoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.MissionJoinDTO request) {
        MemberMission memberMission = memberMissionCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMissionJoinResultDTO(memberMission));
    }
}
