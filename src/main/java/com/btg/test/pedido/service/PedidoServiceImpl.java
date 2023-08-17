package com.btg.test.pedido.service;

import com.btg.test.pedido.model.Pedido;
import com.btg.test.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Float valorTotalPedido(Long codigoPedido) {
        Pedido pedido = pedidoRepository.findById(codigoPedido).orElse(null);
        Float total = 0.00f;

        total = pedido.getItens().stream()
                .map(item -> item.getPreco() * item.getQuantidade())
                .reduce(total, Float::sum);

        return total;
    }

    @Override
    public Long quantidadePedidoPorCliente(Long codigoCliente) {
        return (long)pedidoRepository.findAllByCodigoCliente(codigoCliente).size();
    }

    @Override
    public List<Pedido> listaPedidosPorCliente(Long codigoCliente) {
        return pedidoRepository.findAllByCodigoCliente(codigoCliente);
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido criar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public boolean buscar(Long codigoPedido) {
        if(pedidoRepository.findById(codigoPedido) != null)
            return false;
        return true;
    }
}
