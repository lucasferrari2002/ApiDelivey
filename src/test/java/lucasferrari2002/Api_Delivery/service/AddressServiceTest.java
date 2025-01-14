package lucasferrari2002.Api_Delivery.service;

import lucasferrari2002.Api_Delivery.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @InjectMocks
    private AddressService addressService;
    @Mock
    private RestTemplate restTemplate;

    @Test
    void testIsValidAddress(){
        Address addressTest = new Address("Avenida Moinho Fabrini",
                "592", "Independência", "São Bernardo do Campo", "São Paulo", "09861160", "Brasil" );

        String jsonResponse = "{"
                + "\"cep\":\"09861-160\","
                + "\"logradouro\":\"Avenida Moinho Fabrini\","
                + "\"complemento\":\"até 609/610\","
                + "\"unidade\":\"\","
                + "\"bairro\":\"Independência\","
                + "\"localidade\":\"São Bernardo do Campo\","
                + "\"uf\":\"SP\","
                + "\"estado\":\"São Paulo\","
                + "\"regiao\":\"Sudeste\","
                + "\"ibge\":\"3548708\","
                + "\"gia\":\"6350\","
                + "\"ddd\":\"11\","
                + "\"siafi\":\"7075\""
                + "}";

        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonResponse, HttpStatus.OK);

        Mockito.when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(responseEntity);

        boolean result = addressService.isValidAddress(addressTest);

        assertTrue(result, "Deu certo");


    }

}
