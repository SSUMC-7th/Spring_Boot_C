package umc.spring.apiPayoad.exception.handler;

import umc.spring.apiPayoad.code.BaseErrorCode;
import umc.spring.apiPayoad.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
