package umc.spring.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember=QMember.member;

    @Override
    public List<Member> findByMemberId(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null){
            predicate.and(qMember.id.eq(memberId));
        }

        return jpaQueryFactory
                .selectFrom(qMember)
                .where(predicate)
                .fetch();
    }
}
