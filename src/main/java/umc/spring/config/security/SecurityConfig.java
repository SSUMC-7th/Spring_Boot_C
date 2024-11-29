package umc.spring.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // 스프링 시큐리티 설정 활성화 -> 기본 설정보다 커스텀 설정이 우선 적용
@Configuration
public class SecurityConfig {

    // SecurityFilterChain 정의부분.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http    
                // http 요청에 대한 접근 제어 설정
                .authorizeHttpRequests((requests) -> requests 
                        // 특정 URL 패턴에 접근 권한 설정
                        .requestMatchers("/", "/home", "/signup", "/members/signup", "/css/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // 위 두가지 경우 외엔 인증 요구
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        // 커스텀 로그인 페이지 경로 지정
                        .loginPage("/login") 
                        // 로그인 성공 시 "/home" 경로로 리다이렉트
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        // logout 경로로 로그아웃 처리
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    // 비밀번호를 암호화해서 저장하기 위한 Encorder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
