package com.btg.test.pedido.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "Pedido")
public class Pedido {
    @Id
    private Long codigoPedido;
    private Long codigoCliente;
    private List<Item> itens;

}
