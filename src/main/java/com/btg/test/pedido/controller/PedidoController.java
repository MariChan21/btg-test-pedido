package com.btg.test.pedido.controller;

import com.btg.test.pedido.model.Pedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoController {

    ResponseEntity<?> criar(Pedido pedido);

    ResponseEntity<List<Pedido>> listar();
    ResponseEntity<Float> valorTotalPedido(Long codigoPedido);

    ResponseEntity<Long> quantidadePedidoPorCliente(Long codigoCliente);

    ResponseEntity<List<Pedido>> listaPedidosPorCliente(Long codigoCliente);
}
