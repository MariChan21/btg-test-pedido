//package com.btg.test.pedido;
//
//import com.btg.test.pedido.model.Pedido;
//import com.btg.test.pedido.repository.PedidoRepository;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class QueueConsumer {
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @RabbitListener(queues = "pedidos")
//    public void processMessage(Pedido pedido) {
//        pedidoRepository.save(pedido);
//    }
//}
