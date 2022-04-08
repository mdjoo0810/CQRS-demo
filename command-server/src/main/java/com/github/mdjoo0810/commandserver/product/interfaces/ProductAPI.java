package com.github.mdjoo0810.commandserver.product.interfaces;

import com.github.mdjoo0810.commandserver.product.application.ProductCommandFacade;
import com.github.mdjoo0810.commandserver.product.application.ProductQueryFacade;
import com.github.mdjoo0810.commandserver.product.domain.usecase.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductAPI {

    private final ProductCommandFacade productCommandFacade;
    private final ProductQueryFacade productQueryFacade;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(
            @PathVariable Long id
    ) {
        ProductInfo productInfo = productQueryFacade.getProductInfo(id);
        return ResponseEntity.ok(new ProductResponse(productInfo));
    }

    @PostMapping
    public ResponseEntity<Long> register(
            @RequestBody RegisterProductRequest request
    ) {
        Long id = productCommandFacade.register(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
