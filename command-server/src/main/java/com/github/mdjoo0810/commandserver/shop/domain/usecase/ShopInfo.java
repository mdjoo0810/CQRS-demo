package com.github.mdjoo0810.commandserver.shop.domain.usecase;

import com.github.mdjoo0810.commandserver.shop.domain.entity.Shop;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopInfo {

    private Long id;
    private String name;
    private String tel;

    public ShopInfo(Shop shop) {
        this.id = shop.getId();
        this.name = shop.getName();
        this.tel = shop.getTel();
    }
}
