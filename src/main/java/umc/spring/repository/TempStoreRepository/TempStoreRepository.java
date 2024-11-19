package umc.spring.repository.TempStoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

public interface TempStoreRepository extends JpaRepository<Store, Long>, TempStoreRepositoryCustom {
}
