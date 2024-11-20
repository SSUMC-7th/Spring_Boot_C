package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayoad.code.status.ErrorStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.IsChallenging;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChallengingValidator implements ConstraintValidator<IsChallenging, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isValid = memberMissionRepository.existsById(missionId);

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ON_CHALLANGE.toString())
                    .addConstraintViolation();
        }

        return !isValid;
    }
}
