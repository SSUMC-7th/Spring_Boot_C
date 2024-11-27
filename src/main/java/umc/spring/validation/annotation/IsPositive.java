package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PositiveValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositiveValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface IsPositive {

    String message() default "페이지 값이 음수입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
