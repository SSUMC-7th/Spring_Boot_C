package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        //검증을 위해 어노테이션 붙임
        @NotBlank
        String name;
        @NotNull
        @Email
        String email;
        @NotNull
        String password;
        @NotNull
        Integer gender;
        @NotNull
        Integer age;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min=5, max=12)
        String address;
        @Size(min=5, max=12)
        String specAddress;
        @NotNull
        Role role;
        @ExistCategories
        List<Long> preferCategory; //Long인 이유는 프론트엔드에서 사용자가 선택한 음식 카테고리 값이 id값으로 넘겨주기 때문
    }
}
