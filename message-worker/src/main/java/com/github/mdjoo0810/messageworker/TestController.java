package com.github.mdjoo0810.messageworker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ProductRepository productRepository;
    @GetMapping("/{id}")
    public ResponseEntity<ReadProduct> get(@PathVariable Long id) {
        ReadProduct no = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no"));
        return ResponseEntity.ok(no);
    }
}
