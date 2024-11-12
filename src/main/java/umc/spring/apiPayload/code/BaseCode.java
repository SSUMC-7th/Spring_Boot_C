package umc.spring.apiPayload.code;

import java.security.cert.CertPathValidatorException;

public interface BaseCode {

    //status에서 두 개의 메소드를 반드시 override할 것을 강제

    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();
}
