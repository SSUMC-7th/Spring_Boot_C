package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.validation.annotation.IsPositive;

public class PositiveValidator implements ConstraintValidator<IsPositive, Integer> {
    @Override
    public void initialize(IsPositive constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if(integer > 0) {
            return true;
        }
        else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_EXCEPTION.toString())
                    .addConstraintViolation();
        }
        return false;
    }
}