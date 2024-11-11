package umc.spring.apiPayload.code;

public interface BaseErrorCode {

    //status에서 두 개의 메소드를 반드시 override할 것을 강제

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
