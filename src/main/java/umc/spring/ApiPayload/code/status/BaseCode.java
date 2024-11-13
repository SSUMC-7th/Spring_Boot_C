package umc.spring.ApiPayload.code.status;

import umc.spring.ApiPayload.code.ReasonDTO;

public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}
