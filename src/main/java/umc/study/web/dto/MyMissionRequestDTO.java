package umc.study.web.dto;

import lombok.Getter;

import java.util.List;

public class MyMissionRequestDTO {
    @Getter
    public static class challengeDTO{
        Long memberId;
        List<Long> challengeMissions;
    }
}
