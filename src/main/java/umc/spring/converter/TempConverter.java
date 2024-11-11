package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter {

    //DTO 생성 메소드
    public static TempResponse.TempTestDTO toTempTestDTO(){  //메소드 형식 : to[생성되는 것]
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    //임시 예외처리
    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
