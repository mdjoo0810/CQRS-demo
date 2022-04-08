package com.github.mdjoo0810.commandserver.product.domain.usecase;

import com.github.mdjoo0810.commandserver.product.domain.entity.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductManager implements Products {

    private final ProductReader productReader;

    @Override
    @Transactional
    public ProductInfo getProduct(Long id) {
        return new ProductInfo(productReader.getProduct(id));
    }
}
