package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter {
    // DTO 생성 메소드
    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("This is TEST!")
                .build();
    }

    // DTO 생성 메소드
    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
