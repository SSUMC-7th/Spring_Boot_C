package umc.spring.ApiPayload.exception.handler;

import umc.spring.ApiPayload.code.BaseErrorCode;
import umc.spring.ApiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}