package lucasferrari2002.Api_Delivery.service;

import lucasferrari2002.Api_Delivery.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @InjectMocks
    private AddressService addressService;


    @Test
    void testIsValidAddress(){
        Address addressTest = new Address("Avenida Moinho Fabrini",
                "592", "Independência", "São Bernardo do Campo", "São Paulo", "09861160", "Brasil" );

        ValidadorAddress mockValidator1 = Mockito.mock(ValidadorAddress.class);
        ValidadorAddress mockValidator2 = Mockito.mock(ValidadorAddress.class);

        Mockito.when(mockValidator1.validar(addressTest)).thenReturn(true);
        Mockito.when(mockValidator2.validar(addressTest)).thenReturn(true);
        List<ValidadorAddress> validators = Arrays.asList(mockValidator1, mockValidator2);
        AddressService service = new AddressService(validators);


        boolean result = service.isValidAddress(addressTest);

        assertTrue(result, "Deu certo");


    }

}
