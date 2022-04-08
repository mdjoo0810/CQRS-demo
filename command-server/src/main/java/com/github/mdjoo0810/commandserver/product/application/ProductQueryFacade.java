package com.github.mdjoo0810.commandserver.product.application;

import com.github.mdjoo0810.commandserver.product.domain.entity.ProductReader;
import com.github.mdjoo0810.commandserver.product.domain.usecase.ProductInfo;
import com.github.mdjoo0810.commandserver.product.domain.usecase.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryFacade {

    private final Products products;

    public ProductInfo getProductInfo(Long id) {
        return products.getProduct(id);
    }

}
