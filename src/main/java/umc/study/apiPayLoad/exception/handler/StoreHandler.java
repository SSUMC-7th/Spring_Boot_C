package umc.study.apiPayLoad.exception.handler;

import umc.study.apiPayLoad.code.BaseErrorCode;
import umc.study.apiPayLoad.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
