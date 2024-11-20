package umc.spring.ApiPayload.exception.handler;

import umc.spring.ApiPayload.code.BaseErrorCode;
import umc.spring.ApiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {

    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}