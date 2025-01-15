package lucasferrari2002.Api_Delivery.service;

import com.google.gson.Gson;
import lucasferrari2002.Api_Delivery.model.Address;
import lucasferrari2002.Api_Delivery.model.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepValidator implements ValidadorAddress {

    private RestTemplate restTemplate;

    @Autowired
    public ViaCepValidator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validar(Address address){
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
