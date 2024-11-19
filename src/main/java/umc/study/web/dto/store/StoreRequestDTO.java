package umc.study.web.dto.store;

import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class JoinDTO{
        String name;
        String address;
    }
}
