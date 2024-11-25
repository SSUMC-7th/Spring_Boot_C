package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.ExistMemberMission;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, Long> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long memberMissionId, ConstraintValidatorContext context) {
        boolean isValid = memberMissionRepository.existsById(memberMissionId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
