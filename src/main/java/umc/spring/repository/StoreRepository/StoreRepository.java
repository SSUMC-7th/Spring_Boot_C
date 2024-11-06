package umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

// jpaRepository<Store, Long>은 왜 Long이지?
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
