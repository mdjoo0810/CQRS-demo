package com.github.mdjoo0810.commandserver.product.interfaces;

import com.github.mdjoo0810.commandserver.product.application.ProductCommandFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductAPI {

    private final ProductCommandFacade productCommandFacade;

    @PostMapping
    public ResponseEntity<Long> register(
            @RequestBody RegisterProductRequest request
    ) {
        Long id = productCommandFacade.register(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
