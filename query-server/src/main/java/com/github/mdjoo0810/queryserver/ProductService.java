package com.github.mdjoo0810.queryserver;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Cacheable(cacheNames = CacheKey.PRODUCT, key = "#id")
    public ReadProduct getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("데이터가 없습니다."));
    }

}
