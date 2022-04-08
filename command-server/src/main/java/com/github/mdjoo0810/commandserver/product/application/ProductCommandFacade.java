package com.github.mdjoo0810.commandserver.product.application;

import com.github.mdjoo0810.commandserver.product.domain.usecase.RegisterProduct;
import com.github.mdjoo0810.commandserver.product.domain.usecase.RegisterProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandFacade {

    private final RegisterProduct registerProduct;
    private final RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "product.exchange";

    public Long register(RegisterProductCommand command) {
        Long registerId = registerProduct.register(command);
        // Message Send
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "product.#", registerId);
        return registerId;
    }

}
