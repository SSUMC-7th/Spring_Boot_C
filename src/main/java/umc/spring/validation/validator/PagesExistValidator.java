package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.ExistPage;

@Component
@RequiredArgsConstructor
public class PagesExistValidator implements ConstraintValidator<ExistPage, Integer> {

    @Override
    public void initialize(ExistPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 값이 null이거나 0보다 작으면 검증 실패
        if (value == null || value < 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_EXIST.toString())
                    .addConstraintViolation();
            return false;
        }

        // 검증 통과
        return true;
    }
}
