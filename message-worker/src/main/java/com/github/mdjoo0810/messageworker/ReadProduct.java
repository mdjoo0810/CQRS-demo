package com.github.mdjoo0810.messageworker;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadProduct {

    @Id
    private Long _id;

    private String name;
    private int price;
    private ReadShop shop;

    public ReadProduct(ProductResponse product) {
        this._id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.shop = product.getShop();
    }

    @Builder
    public ReadProduct(Long _id, String name, int price, ReadShop readShop) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.shop = readShop;
    }
}
