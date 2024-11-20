package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayLoad.code.status.ErrorStatus;
import umc.study.service.MissionService.MissionRepositoryService;
import umc.study.validation.annotation.ExistMembers;
import umc.study.validation.annotation.ExistMissions;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMissions, List<Long>> {

    private final MissionRepositoryService missionRepositoryService;

    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> missionRepositoryService.isInMissionRepository(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_EXIST.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
