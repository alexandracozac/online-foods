package org.fasttrackit.onlinefoods.persistence;

import org.fasttrackit.onlinefoods.domain.Foods;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodsRepository extends PagingAndSortingRepository<Foods, Long> {
}
