package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StoreConverter {

    private final RegionRepository regionRepository;

    public static StoreResponseDTO.StoreRegisterResultDTO toStoreRegisterResult(Store store) {
        return StoreResponseDTO.StoreRegisterResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Store toStore(StoreRequestDTO.StoreRegisterDTO request){

        Region region=regionRepository.findById(request.getRegionId()).get();

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        if (reviewList == null) {
            System.out.println("reviewList is null");
        } else if (reviewList.isEmpty()) {
            System.out.println("reviewList is empty");
        } else {
            System.out.println("reviewList contains elements: " + reviewList.getTotalPages());
        }

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        System.out.println("reviewList size: " + reviewList.getTotalElements());

        for(StoreResponseDTO.ReviewPreViewDTO review:reviewPreViewDTOList){
            System.out.println(review);
        }

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
