package umc.study.apiPayLoad.exception.handler;

import umc.study.apiPayLoad.code.BaseErrorCode;
import umc.study.apiPayLoad.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
