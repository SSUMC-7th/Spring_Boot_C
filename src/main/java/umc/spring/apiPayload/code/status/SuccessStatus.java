package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.boot.archive.scan.internal.DisabledScanner;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseCode;
import umc.spring.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    //일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    //이곳에 _OK말고도 성공 응답을 계속 추가할 수 있음

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

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
