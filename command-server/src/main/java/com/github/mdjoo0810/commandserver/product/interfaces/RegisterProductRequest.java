package com.github.mdjoo0810.commandserver.product.interfaces;

import com.github.mdjoo0810.commandserver.product.domain.usecase.RegisterProductCommand;
import lombok.Getter;

@Getter
public class RegisterProductRequest {

    private final String name;
    private final int price;
    private final Long shopId;

    public RegisterProductRequest(String name, int price, Long shopId) {
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }

    public RegisterProductCommand toCommand() {
        return RegisterProductCommand.builder()
                .name(name)
                .price(price)
                .shopId(shopId)
                .build();
    }
}
