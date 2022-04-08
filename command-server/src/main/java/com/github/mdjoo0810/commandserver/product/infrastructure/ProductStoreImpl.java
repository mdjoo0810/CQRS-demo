package com.github.mdjoo0810.commandserver.product.infrastructure;

import com.github.mdjoo0810.commandserver.product.domain.entity.Product;
import com.github.mdjoo0810.commandserver.product.domain.entity.ProductStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStoreImpl implements ProductStore {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public void store(Product initProduct) {
        productJpaRepository.save(initProduct);
    }
}
