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
import umc.spring.ApiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistPage;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistPage;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final StoreQueryService storeQueryService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }


    @GetMapping("/{memberId}/challenging-missions")
    @Operation(summary = "특정 시용자의 도전 중인 미션 목록 조회 API",description = "특정 사용자의 도전 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지는 1이상입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewListDTO> getChallengingMissionList(@ExistMembers @PathVariable(name = "memberId") Long memberId, @ExistPage @RequestParam(name = "page") Integer page){
        Page<MemberMission> missionList = memberMissionCommandService.getMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreViewListDTO(missionList));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 사용자의 리뷰 목록 조회 API", description = "특정 사용자의 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. 페이지는 10개로 구분되며, 첫 페이지는 1로 설정되어 있습니다. query String으로 page 번호를 주시면 해당하는 페이지의 List가 조회됩니다.")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디, path variable입니당."),
            @Parameter(name = "page", description = "페이지는 1 이상입니당.")
    })
    public ApiResponse<MemberResponseDTO.MemberReviewPreviewListDTO> getMemberReviewList(@ExistMembers @PathVariable(name = "memberId") Long memberId, @ExistPage @RequestParam(name="page") Integer page){
        Page<Review> reviewList = memberCommandService.getMemberReviewList(memberId,page);

        return ApiResponse.onSuccess(MemberConverter.memberReviewPreviewListDTO(reviewList));
    }
}
