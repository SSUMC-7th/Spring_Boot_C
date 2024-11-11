package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @Builder //우리가 만드는 인스턴스들은 모두 빌더 패턴 사용 <->RequestDTO
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO{
        //public static class로 내부 클래스를 만드는 이유는
        //DTO 자체는 수 많은 곳에서 사용될 수 있기 때문에
        //static class로 만들면 매번 class 파일을 만들 필요 없이
        //범용적으로 DTO를 사용할 수 있음

        String testString;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;  //flag가 2인 경우 exception을 만드는 경우에 쓰임
    }
}
