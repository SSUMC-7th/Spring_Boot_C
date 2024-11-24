package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemMissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemMissionService.MemMissionService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MemMissionRequestDTO;
import umc.spring.web.dto.MemMissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

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

    @GetMapping("/{memberId}/challenging")
    @Operation(summary = "특정 사용자의 진행중인 미션 목록 조회 API", description = "특정 사용자의 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 넣어주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemMissionResponseDTO.ChallengingMissionListDTO> getMemMissionList(@ExistMembers @PathVariable(name="memberId") Long memberId, @CheckPage @RequestParam(name="page") Integer page){
        Integer checkPage = memMissionService.checkPage(page);
        Page<MemberMission> memMissionList = memMissionService.getMemMissionList(memberId, checkPage);
        return ApiResponse.onSuccess(MemMissionConverter.toChallengingMissionListDTO(memMissionList));
    }
}
