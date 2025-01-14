package lucasferrari2002.Api_Delivery.service;

import com.google.gson.Gson;
import lucasferrari2002.Api_Delivery.model.Address;
import lucasferrari2002.Api_Delivery.model.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    private RestTemplate restTemplate;

    @Autowired
    public AddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isValidAddress(Address address){
        if(camposValidos(address)){
            return validarCepComViaCep(address);
        }
        return false;
    }

    private boolean camposValidos(Address address){
        if(!StringUtils.hasText(address.getStreet()) || !StringUtils.hasText(address.getNumber()) || !StringUtils.hasText(address.getNeighborhood())
                || !StringUtils.hasText(address.getCity()) || !StringUtils.hasText(address.getState())
                || !StringUtils.hasText(address.getPostalCode()) || !StringUtils.hasText(address.getCountry())){
            return false;
        }
        return true;
    }

    private boolean validarCepComViaCep(Address address){
        String url = "https://viacep.com.br/ws/" + address.getPostalCode() + "/json/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()){
            String responseBody = response.getBody();
            if (responseBody != null && responseBody.contains("\"erro\": true")) {
                return false;
            }
            Gson gson = new Gson();
            ViaCepResponse viaCepResponse = gson.fromJson(responseBody, ViaCepResponse.class);

            return viaCepResponse.getBairro().equalsIgnoreCase(address.getNeighborhood()) &&
                    viaCepResponse.getLocalidade().equalsIgnoreCase(address.getCity()) &&
                    viaCepResponse.getEstado().equalsIgnoreCase(address.getState());

        }
        return false;
    }







}
