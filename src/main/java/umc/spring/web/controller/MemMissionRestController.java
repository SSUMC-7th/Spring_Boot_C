package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemMissionService.MemMissionService;
import umc.spring.web.dto.MemMissionRequestDTO;
import umc.spring.web.dto.MemMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemMissionRestController {

    private final MemMissionService memMissionService;

    @PostMapping("/challenging")
    public ApiResponse<MemMissionResponseDTO.RegisterChallengingResultDTO> register(@RequestBody @Valid MemMissionRequestDTO.RegisterChallengingDTO request){
        MemberMission memberMission=memMissionService.addMemMission(request);
        return ApiResponse.onSuccess(MemMissionConverter.registerChallengingResultDTO(memberMission));
    }
}
