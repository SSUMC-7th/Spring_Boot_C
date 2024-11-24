package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayLoad.code.status.ErrorStatus;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.service.MemberService.MemberRepositoryService;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMembers;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberRepositoryService memberRepositoryService;

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = memberRepositoryService.isInMemberRepository(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
