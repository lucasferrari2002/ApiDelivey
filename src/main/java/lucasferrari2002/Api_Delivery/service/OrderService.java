package lucasferrari2002.Api_Delivery.service;

import lucasferrari2002.Api_Delivery.model.Order;
import lucasferrari2002.Api_Delivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido nao encontrado"));
    }

}
