package com.github.mdjoo0810.commandserver.shop.interfaces;

import com.github.mdjoo0810.commandserver.shop.domain.usecase.ShopInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopResponse {

    private Long id;
    private String name;
    private String tel;

    public ShopResponse(ShopInfo shopInfo) {
        this.id = shopInfo.getId();
        this.name = shopInfo.getName();
        this.tel = shopInfo.getTel();
    }
}
