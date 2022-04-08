package com.github.mdjoo0810.messageworker;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@ToString
public class ReadShop {

    private Long id;
    private String name;
    private String tel;

    public ReadShop(Long id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}
