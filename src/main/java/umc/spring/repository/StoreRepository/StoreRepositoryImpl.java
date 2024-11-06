package umc.spring.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QStore;
import umc.spring.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;  // 쿼리를 만들기 위해 선언
    private final QStore store = QStore.store;      // store 엔티티를 사용하기 위해 선언

    // StoreRepositoryCustom의 메서드를 오버라이드
    // dynamicQueryWithBooleanBuilder 함수를 쓰면 return의 쿼리가 나간다.
    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();    // 쿼리의 조건을 주기 위해 선언

        if(name != null) {
            predicate.and(store.name.eq(name));
        }

        if(score != null) {
            predicate.and(store.score.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}
