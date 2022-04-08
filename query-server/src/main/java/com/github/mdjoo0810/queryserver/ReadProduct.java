package com.github.mdjoo0810.queryserver;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("product")
@Getter
@NoArgsConstructor
public class ReadProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long _id;

    private String name;
    private int price;
    private ReadShop shop;

    @Builder
    public ReadProduct(Long _id, String name, int price, ReadShop readShop) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.shop = readShop;
    }
}

