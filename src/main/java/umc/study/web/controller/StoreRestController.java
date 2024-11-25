package umc.study.web.controller;

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
import umc.study.apiPayLoad.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.converter.review.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.service.StoreService.StoreReviewQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreReviewQueryService storeReviewQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.JoinDTO request) {
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 매장의 리뷰 목록 조회 API", description = "특정 매장의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "매장의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.MyStoreReviewPreviewListDTO> getReviewsList(@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = storeReviewQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.storeReviewPreViewListDTO(reviewList));
    }
}
