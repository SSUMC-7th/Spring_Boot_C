package umc.spring.apiPayoad.exception.handler;

import umc.spring.apiPayoad.code.BaseErrorCode;
import umc.spring.apiPayoad.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
