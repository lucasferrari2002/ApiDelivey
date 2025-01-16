package lucasferrari2002.Api_Delivery.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private OrderStatus status;

    private LocalTime horarioDoPedido;

    public Order(Long id, String customerName, Cliente cliente, OrderStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.cliente = cliente;
        this.status = status;
        this.horarioDoPedido = LocalTime.now();
    }
}
