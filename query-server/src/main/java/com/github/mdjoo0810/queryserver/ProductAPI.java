package com.github.mdjoo0810.queryserver;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductAPI {

    private final ProductService productService;

    @DeleteMapping("/reset")
    public ResponseEntity<String> reset() {

        return ResponseEntity.ok("reset");
    }

    @GetMapping("/v1/products/{id}")
    public ReadProduct getAll(
            @PathVariable Long id
    ) {
        return productService.getProduct(id);
    }

}
