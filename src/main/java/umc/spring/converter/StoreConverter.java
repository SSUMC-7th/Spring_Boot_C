package umc.spring.converter;


import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDTO request, Region region){

        return Store.builder()
                .name(request.getName())
                .region(region)
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewDTO reviewPreViewDTO(Review review){
        return null;
    }
    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}