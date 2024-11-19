package umc.spring.apiPayoad.exception.handler;

import umc.spring.apiPayoad.code.BaseErrorCode;
import umc.spring.apiPayoad.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
