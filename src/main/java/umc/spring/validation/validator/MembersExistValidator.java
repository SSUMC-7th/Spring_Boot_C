package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.ExistMembers;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MembersExistValidator implements ConstraintValidator<ExistMembers, List<Long>> {

    private final MemberQueryService memberQueryService;

    @Override
    public void initialize(ExistMembers constraintAnnotation) {
        // Optional: No custom initialization required, so calling the parent implementation.
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> memberIds, ConstraintValidatorContext context) {
        // Validate that all IDs exist in the repository.
        boolean allMembersExist = memberIds.stream()
                .allMatch(memberId -> memberQueryService.findMember(memberId).isPresent());

        if (!allMembersExist) {
            // Disable default validation message.
            context.disableDefaultConstraintViolation();

            // Add custom validation message using ErrorStatus.
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return allMembersExist;
    }
}
