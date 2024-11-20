package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayLoad.code.status.ErrorStatus;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.service.MemberMissionService.MemberMissionRepositoryService;
import umc.study.service.MemberService.MemberRepositoryService;
import umc.study.validation.annotation.ExistMemberMission;
import umc.study.web.dto.MyMissionRequestDTO;
import umc.study.web.dto.MyMissionResponseDTO;


@Component
@RequiredArgsConstructor
public class MemberMissionAlreadyExistValidator implements ConstraintValidator<ExistMemberMission, MyMissionRequestDTO.challengeDTO> {

    private final MemberMissionRepositoryService memberMissionRepositoryService;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MyMissionRequestDTO.challengeDTO challengeDTO, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = memberMissionRepositoryService.checkChallenging(challengeDTO.getMemberId(), challengeDTO.getChallengeMissions());

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
