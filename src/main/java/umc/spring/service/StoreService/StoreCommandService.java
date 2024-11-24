package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStore(StoreRequestDTO.StoreRegisterDTO request);
    Page<Review> getReviewList(Long StoreId, Integer page);


}
