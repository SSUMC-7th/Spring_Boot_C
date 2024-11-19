package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayLoad.code.status.ErrorStatus;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistMembers;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMembers, List<Long>> {

    private final MemberRepository memberRepository;

    @Override
    public void initialize(ExistMembers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> memberRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
