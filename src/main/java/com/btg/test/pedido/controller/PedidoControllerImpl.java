package com.btg.test.pedido.controller;

import com.btg.test.pedido.model.Pedido;
import com.btg.test.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoControllerImpl implements PedidoController{

    @Autowired
    private PedidoService pedidoService;

    @Override
    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.criar(pedido));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    @Override
    @GetMapping("/valorTotalPedido/{codigoPedido}")
    public ResponseEntity<Float> valorTotalPedido(@PathVariable Long codigoPedido) {
        return ResponseEntity.ok(pedidoService.valorTotalPedido(codigoPedido));
    }

    @Override
    @GetMapping("/quantidadePedidoPorCliente/{codigoCliente}")
    public ResponseEntity<Long> quantidadePedidoPorCliente(@PathVariable Long codigoCliente) {
        return ResponseEntity.ok(pedidoService.quantidadePedidoPorCliente(codigoCliente));
    }

    @Override
    @GetMapping("/{codigoCliente}")
    public ResponseEntity<List<Pedido>> listaPedidosPorCliente(@PathVariable Long codigoCliente) {
        return ResponseEntity.ok(pedidoService.listaPedidosPorCliente(codigoCliente));
    }
}
