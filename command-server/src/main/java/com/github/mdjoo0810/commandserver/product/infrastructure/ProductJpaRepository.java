package com.github.mdjoo0810.commandserver.product.infrastructure;

import com.github.mdjoo0810.commandserver.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

}
