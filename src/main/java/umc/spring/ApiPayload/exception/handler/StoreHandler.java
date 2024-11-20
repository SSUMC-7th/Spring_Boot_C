package umc.spring.ApiPayload.exception.handler;

import umc.spring.ApiPayload.code.BaseErrorCode;
import umc.spring.ApiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}