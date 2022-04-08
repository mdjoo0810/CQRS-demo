package com.github.mdjoo0810.commandserver.product.application;

import com.github.mdjoo0810.commandserver.product.domain.usecase.RegisterProduct;
import com.github.mdjoo0810.commandserver.product.domain.usecase.RegisterProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandFacade {

    private final RegisterProduct registerProduct;

    public Long register(RegisterProductCommand command) {
        Long registerId = registerProduct.register(command);
        // Message Send
        return registerId;
    }

}
