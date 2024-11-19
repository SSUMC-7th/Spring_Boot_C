package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.validation.annotation.ExistCategoreis;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategoreis, List<Long>> {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistCategoreis constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString())
                    .addConstraintViolation();
        }
        return isValid;
    }
}
