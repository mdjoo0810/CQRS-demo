package com.github.mdjoo0810.commandserver.product.domain.entity;

import com.github.mdjoo0810.commandserver.shop.domain.entity.Shop;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @Builder
    public Product(String name, int price, Shop shop) {
        this.name = name;
        this.price = price;
        this.shop = shop;
    }
}
