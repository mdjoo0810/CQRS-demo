package com.github.mdjoo0810.commandserver.product.domain.usecase;

import com.github.mdjoo0810.commandserver.product.domain.entity.Product;
import com.github.mdjoo0810.commandserver.shop.domain.usecase.ShopInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductInfo {

    private Long id;
    private String name;
    private int price;
    private ShopInfo shop;

    public ProductInfo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.shop = new ShopInfo(product.getShop());
    }
}
