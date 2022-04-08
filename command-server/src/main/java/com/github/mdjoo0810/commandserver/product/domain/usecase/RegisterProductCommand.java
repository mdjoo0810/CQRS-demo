package com.github.mdjoo0810.commandserver.product.domain.usecase;

import com.github.mdjoo0810.commandserver.product.domain.entity.Product;
import com.github.mdjoo0810.commandserver.shop.domain.entity.Shop;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterProductCommand {

    private final String name;
    private final int price;
    private final Long shopId;

    @Builder
    public RegisterProductCommand(String name, int price, Long shopId) {
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }

    public Product toEntity(Shop shop) {
        return Product.builder()
                .shop(shop)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
