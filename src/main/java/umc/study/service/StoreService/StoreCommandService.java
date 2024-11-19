package umc.study.service.StoreService;

import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {

    public Store joinMember(StoreRequestDTO.JoinDTO request);
}
