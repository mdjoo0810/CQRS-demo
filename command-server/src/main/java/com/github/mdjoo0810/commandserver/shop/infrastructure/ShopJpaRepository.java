package com.github.mdjoo0810.commandserver.shop.infrastructure;

import com.github.mdjoo0810.commandserver.shop.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopJpaRepository extends JpaRepository<Shop, Long> {
}
