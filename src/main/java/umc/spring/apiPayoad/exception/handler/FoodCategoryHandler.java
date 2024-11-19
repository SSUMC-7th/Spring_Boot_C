package umc.spring.apiPayoad.exception.handler;

import umc.spring.apiPayoad.code.BaseErrorCode;
import umc.spring.apiPayoad.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
