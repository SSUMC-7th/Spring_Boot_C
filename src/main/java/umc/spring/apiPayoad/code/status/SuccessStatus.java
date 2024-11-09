package umc.spring.apiPayoad.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayoad.code.BaseCode;
import umc.spring.apiPayoad.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON 200", "성공입니다.");

    // (현재는  _OK 만 있는 데 성공 응답을 추가하고 싶으면 ENUM 형식으로 계속 밑에 추가하면 됩니다!)

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    // BaseCode 인터페이스를 오버라이딩한다.
    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
