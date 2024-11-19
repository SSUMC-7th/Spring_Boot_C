package umc.spring.ApiPayload.exception.handler;

import umc.spring.ApiPayload.code.BaseErrorCode;
import umc.spring.ApiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}