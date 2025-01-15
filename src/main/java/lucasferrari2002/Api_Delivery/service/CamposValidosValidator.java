package lucasferrari2002.Api_Delivery.service;

import lucasferrari2002.Api_Delivery.model.Address;
import org.springframework.util.StringUtils;

public class CamposValidosValidator implements ValidadorAddress{
    @Override
    public boolean validar(Address address) {
        if(!StringUtils.hasText(address.getStreet()) || !StringUtils.hasText(address.getNumber()) || !StringUtils.hasText(address.getNeighborhood())
                || !StringUtils.hasText(address.getCity()) || !StringUtils.hasText(address.getState())
                || !StringUtils.hasText(address.getPostalCode()) || !StringUtils.hasText(address.getCountry())){
            return false;
        }
        return true;
    }
}
