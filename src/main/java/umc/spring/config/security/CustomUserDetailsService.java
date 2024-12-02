package umc.spring.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //Spring Security가 호출
        Member member = memberRepository.findByEmail(username) //username은 입력받은 이메일임
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다: " + username));

        return org.springframework.security.core.userdetails.User //Spring Security는 반환된 User 객체의 정보를 사용하여 인증을 수행
                .withUsername(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().name())
                .build();
    }
}
