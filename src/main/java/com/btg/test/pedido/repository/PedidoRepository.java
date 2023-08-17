package com.btg.test.pedido.repository;

import com.btg.test.pedido.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepository extends MongoRepository<Pedido,Long> {

    List<Pedido> findAllByCodigoCliente(Long codigoCliente);

}
