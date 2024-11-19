package umc.spring.repository.TempStoreRepository;

import umc.spring.domain.Store;

import java.util.List;

public interface TempStoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
