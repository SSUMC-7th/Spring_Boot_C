package umc.spring.apiPayoad.exception.handler;

import umc.spring.apiPayoad.code.BaseErrorCode;
import umc.spring.apiPayoad.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
