package lucasferrari2002.Api_Delivery.service;


import lucasferrari2002.Api_Delivery.model.Cliente;
import lucasferrari2002.Api_Delivery.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Nenhum cliente com este cpf"));

    }

    public Cliente addCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }




}
