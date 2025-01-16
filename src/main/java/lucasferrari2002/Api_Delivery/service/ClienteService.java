package lucasferrari2002.Api_Delivery.service;


import lucasferrari2002.Api_Delivery.exception.EnderecoInvalidoException;
import lucasferrari2002.Api_Delivery.model.Cliente;
import lucasferrari2002.Api_Delivery.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ValidadorAddress validadorAddress;

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Nenhum cliente com este cpf"));

    }

    public Cliente addCliente(Cliente cliente){
        if(!validadorAddress.validar(cliente.getDadosPessoais().getAddress())){
            throw new EnderecoInvalidoException("O endereço fornecido é inválido.");
        }
        if(clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new IllegalArgumentException(" Esse CPF ja esta cadastrado");
        }
        return clienteRepository.save(cliente);
    }





}
