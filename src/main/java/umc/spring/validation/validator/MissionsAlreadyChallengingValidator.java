package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MemMissionRepository;
import umc.spring.validation.annotation.AlreadyChallenging;

@Component
@RequiredArgsConstructor
public class MissionsAlreadyChallengingValidator implements ConstraintValidator<AlreadyChallenging, Long>{

    private final MemMissionRepository memMissionRepository;

    @Override
    public void initialize(AlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {

        boolean isValid = memMissionRepository.existsByMissionId(missionId);

        if(isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
        }

        return !isValid;
    }
}
