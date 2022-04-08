package com.github.mdjoo0810.commandserver.product.domain.usecase;

import com.github.mdjoo0810.commandserver.product.domain.entity.Product;
import com.github.mdjoo0810.commandserver.product.domain.entity.ProductStore;
import com.github.mdjoo0810.commandserver.shop.domain.entity.Shop;
import com.github.mdjoo0810.commandserver.shop.domain.entity.ShopReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterProduct {

    private final ShopReader shopReader;
    private final ProductStore productStore;

    @Transactional
    public Long register(RegisterProductCommand command) {
        Shop shop = shopReader.getShop(command.getShopId());
        Product initProduct = command.toEntity(shop);
        productStore.store(initProduct);
        return initProduct.getId();
    }

}
