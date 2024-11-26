package umc.spring.validation.annotation;

import jakarta.validation.Payload;

public @interface ExistPage {
    String message() default "페이지는 양수여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
