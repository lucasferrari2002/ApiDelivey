package lucasferrari2002.Api_Delivery.controller;

import jakarta.validation.Valid;
import lucasferrari2002.Api_Delivery.model.Cliente;
import lucasferrari2002.Api_Delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public ResponseEntity<Cliente> addCliente(@Valid @RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.addCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }


}
