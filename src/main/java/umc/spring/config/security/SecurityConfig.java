package umc.spring.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //나의 Spring Security 설정 활성화
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests  //HTTP 요청에 대한 접근 제어 설정
                        .requestMatchers("/", "/home", "/signup", "/member/signup", "/css/**").permitAll() //인증 없이 접근 가능
                        .requestMatchers("/admin/**").hasRole("ADMIN") //ADMIN 역할을 가진 사용자만 접근 가능
                        .anyRequest().authenticated() //그 외 모든 요청에 인증 요청
                )
                .formLogin((form) -> form //폼 기반 로그인 설정
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true) //로그인 성공 시 /home으로 리다이렉트
                        .permitAll() //로그인 페이지는 모든 사용자 접근 가능
                )
                .logout((logout) -> logout //로그아웃 설정
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") //로그아웃 성공 시 /login?logout으로 리다이렉트
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //비밀번호 암호화하여 저장하기 위해 BCryptPasswordEncoder 사용
    }
}
