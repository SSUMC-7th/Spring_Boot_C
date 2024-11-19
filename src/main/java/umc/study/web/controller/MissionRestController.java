package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayLoad.ApiResponse;
import umc.study.service.MissionService.MyMissionCommandService;
import umc.study.web.dto.MyMissionRequestDTO;
import umc.study.web.dto.MyMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {


    private final MyMissionCommandService myMissionCommandService;

    @PostMapping("/my_mission")
    public ApiResponse<MyMissionResponseDTO.challengeResultDTO> join(@RequestBody @Valid MyMissionRequestDTO.challengeDTO request){
        return null;
    }
}
