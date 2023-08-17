package com.btg.test.pedido.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String produto;
    private Long quantidade;
    private Float preco;
}
