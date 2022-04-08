package com.github.mdjoo0810.commandserver.shop.infrastructure;

import com.github.mdjoo0810.commandserver.shop.domain.entity.Shop;
import com.github.mdjoo0810.commandserver.shop.domain.entity.ShopReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShopReaderImpl implements ShopReader {

    private final ShopJpaRepository shopJpaRepository;

    @Override
    public Shop getShop(Long id) {
        return shopJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("상점이 없습니다. Shop id : " + id));
    }
}
