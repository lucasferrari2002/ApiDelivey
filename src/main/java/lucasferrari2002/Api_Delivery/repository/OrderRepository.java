package lucasferrari2002.Api_Delivery.repository;

import lucasferrari2002.Api_Delivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
