package com.github.mdjoo0810.commandserver.product.infrastructure;

import com.github.mdjoo0810.commandserver.product.domain.entity.Product;
import com.github.mdjoo0810.commandserver.product.domain.entity.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product getProduct(Long id) {
        return productJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. Product id : " + id));
    }
}
