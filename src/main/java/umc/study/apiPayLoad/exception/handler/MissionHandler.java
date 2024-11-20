package umc.study.apiPayLoad.exception.handler;

import umc.study.apiPayLoad.code.BaseErrorCode;
import umc.study.apiPayLoad.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
