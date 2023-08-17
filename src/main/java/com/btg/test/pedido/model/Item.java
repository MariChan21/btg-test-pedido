package com.btg.test.pedido.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String produto;
    private Long quantidade;
    private Float preco;

}
