package com.github.mdjoo0810.commandserver.product.interfaces;

import com.github.mdjoo0810.commandserver.product.domain.usecase.ProductInfo;
import com.github.mdjoo0810.commandserver.shop.interfaces.ShopResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductResponse {

    private Long id;
    private String name;
    private int price;
    private ShopResponse shop;

    public ProductResponse(ProductInfo productInfo) {
        this.id = productInfo.getId();
        this.name = productInfo.getName();
        this.price = productInfo.getPrice();
        this.shop = new ShopResponse(productInfo.getShop());
    }
}
