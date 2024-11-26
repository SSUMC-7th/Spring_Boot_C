package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.ApiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> join(@RequestBody @Valid MissionRequestDTO.MissionJoinDto request){
        MemberMission memberMission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(memberMission.getMission()));
    }

    @GetMapping("/")
    public ApiResponse<MissionResponseDTO.StoreMissionPreViewListDTO> getStoreMissionList(@ExistStores @PathVariable(name = "storeId") Long storeId){
        return null;
    }
}
