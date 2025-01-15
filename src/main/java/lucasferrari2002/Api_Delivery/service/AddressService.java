package lucasferrari2002.Api_Delivery.service;

import lucasferrari2002.Api_Delivery.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressService {

    private List<ValidadorAddress> validadores;

    @Autowired
    public AddressService(List<ValidadorAddress> validadores) {
        this.validadores = validadores;
    }

    public boolean isValidAddress(Address address){
        return validadores.stream().allMatch(validador -> validador.validar(address));
    }


}
