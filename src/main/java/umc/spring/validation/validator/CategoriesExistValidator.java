package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
//ExistCategories 어노테이션에 대한 로직을 담을 것이며, 검증 대상이 List<Long>이다.

    private final FoodCategoryRepository foodCategoryRepository; //repository에 접근하는 계층은 무조건 service 하나만 있어야 함

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        //List<Long>의 값을 가진 카테고리가 모두 데이터베이스 안에 있는 지르르 판단하고 없을 경우 false를 반환
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}