package com.btg.test.pedido.controller;

import com.btg.test.pedido.exception.ErrorResponse;
import com.btg.test.pedido.model.Pedido;
import com.btg.test.pedido.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoControllerImpl implements PedidoController{

    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoController.class);
    @Autowired
    private PedidoService pedidoService;

    @Override
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Pedido pedido) {
        if(!pedidoService.buscar(pedido.getCodigoPedido())){
            LOGGER.info("[Pedido] - Criar pedido - Código pedido: {}",pedido.getCodigoPedido());
            return ResponseEntity.ok(pedidoService.criar(pedido));
        }else {
            ErrorResponse errorResponse = new ErrorResponse("Pedido já existente com o código: " + pedido.getCodigoPedido());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }

    }

    @Override
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        LOGGER.info("[Pedido] - Listar Pedidos");
        return ResponseEntity.ok(pedidoService.listar());
    }

    @Override
    @GetMapping("/valor-total-pedido/{codigoPedido}")
    public ResponseEntity<Float> valorTotalPedido(@PathVariable Long codigoPedido) {
        LOGGER.info("[Pedido] - Valor Total Pedido - Código pedido: {}",codigoPedido);
        return ResponseEntity.ok(pedidoService.valorTotalPedido(codigoPedido));
    }

    @Override
    @GetMapping("/quantidade-pedidos-cliente/{codigoCliente}")
    public ResponseEntity<Long> quantidadePedidoPorCliente(@PathVariable Long codigoCliente) {
        LOGGER.info("[Pedido] - Quantidade de Pedidos Por Clientes - Código cliente: {}",codigoCliente);
        return ResponseEntity.ok(pedidoService.quantidadePedidoPorCliente(codigoCliente));
    }

    @Override
    @GetMapping("/{codigoCliente}")
    public ResponseEntity<List<Pedido>> listaPedidosPorCliente(@PathVariable Long codigoCliente) {
        LOGGER.info("[Pedido] - Listar Pedidos Por Cliente - Código cliente: {}",codigoCliente);
        return ResponseEntity.ok(pedidoService.listaPedidosPorCliente(codigoCliente));
    }
}
