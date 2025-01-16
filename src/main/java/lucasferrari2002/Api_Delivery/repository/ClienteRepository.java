package lucasferrari2002.Api_Delivery.repository;

import lucasferrari2002.Api_Delivery.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente>findByCpf(String cpf);
}
