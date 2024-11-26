package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.ExistPage;

public class PagesExistValidator implements ConstraintValidator<ExistPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 값이 null이 아니고 0 이상인지 검증
        return value != null && value >= 0;
    }
}