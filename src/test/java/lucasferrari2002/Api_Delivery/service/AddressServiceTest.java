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

    @Mock
    private ValidadorAddress validadorAddress;


    @Test
    void testIsValidAddress(){
        Address addressTest = new Address();


        Mockito.when(validadorAddress.validar(addressTest)).thenReturn(true);


        AddressService service = new AddressService(validadorAddress);


        boolean result = service.isValidAddress(addressTest);

        assertTrue(result, "Deu certo");


    }

}
