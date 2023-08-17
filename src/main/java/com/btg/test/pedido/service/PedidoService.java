package com.btg.test.pedido.service;

import com.btg.test.pedido.model.Pedido;

import java.util.List;

public interface PedidoService {
    Float valorTotalPedido(Long codigoPedido);

    Long quantidadePedidoPorCliente(Long codigoCliente);

    List<Pedido> listaPedidosPorCliente(Long codigoCliente);

    List<Pedido> listar();

    Pedido criar(Pedido pedido);

    boolean buscar(Long codigoPedido);
}
