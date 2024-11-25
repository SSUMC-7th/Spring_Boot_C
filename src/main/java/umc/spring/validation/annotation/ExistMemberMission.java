package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberMissionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionExistValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
public @interface ExistMemberMission {
    String message() default "사용자가 해당 미션 도전중이 아닙니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
