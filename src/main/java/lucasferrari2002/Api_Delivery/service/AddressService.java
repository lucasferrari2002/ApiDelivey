package lucasferrari2002.Api_Delivery.service;

import lucasferrari2002.Api_Delivery.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {

    private ValidadorAddress validador;

    @Autowired
    public AddressService(ValidadorAddress validador) {
        this.validador = validador;
    }

    public boolean isValidAddress(Address address){
        return validador.validar(address);
    }


}
