package umc.spring.apiPayoad.code;

public interface BaseCode {

    // status에서 두 개의 메소드를 반드시 Override할 것을 강제하는 역할
    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();
}
