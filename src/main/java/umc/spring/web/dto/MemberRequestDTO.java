package umc.spring.web.dto;

import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer age;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory; //Long인 이유는 프론트엔드에서 사용자가 선택한 음식 카테고리 값이 id값으로 넘겨주기 때문
    }
}
