package umc.spring.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QueryDSLConfig { //QueryDSL 설정
    private final EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){ //QueryDSL을 사용하여 JPAQueryFactory를 통하여 쿼리 작성-> Bean 등록
        return new JPAQueryFactory(entityManager);
    }
}