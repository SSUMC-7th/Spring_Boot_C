package umc.spring.ApiPayload.exception.handler;

import umc.spring.ApiPayload.code.BaseErrorCode;
import umc.spring.ApiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
