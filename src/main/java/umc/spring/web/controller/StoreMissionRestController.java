package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayoad.ApiResponse;
import umc.spring.converter.StoreMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.StoreMissionService.StoreMissionCommandService;
import umc.spring.web.dto.StoreMissionRequestDTO;
import umc.spring.web.dto.StoreMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class StoreMissionRestController {

    private final StoreMissionCommandService storeMissionCommandService;

    @PostMapping("/stores")
    public ApiResponse<StoreMissionResponseDTO.StoreMissionJoinResultDTO> addStoreMission(@RequestBody @Valid StoreMissionRequestDTO.StoreMissionJoinDTO request) {
        Mission mission = storeMissionCommandService.joinMission(request);
        return ApiResponse.onSuccess(StoreMissionConverter.toStoreMissionJoinResultDTO(mission));
    }
}
