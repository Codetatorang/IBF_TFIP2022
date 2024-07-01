package ibf2022.tfip.ssf.day17workshopCurrencyConverterApi.service;

import java.io.StringReader;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ibf2022.tfip.ssf.day17workshopCurrencyConverterApi.model.Currency;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class ExchangeRateApiService {
    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String apiUrl;

    public Optional<Currency> getConversion(String baseCode, String targetCode){
        String url = UriComponentsBuilder
                .fromUriString(apiUrl + "/" + apiKey + "/" + "pair" + "/" + baseCode + "/" + targetCode)
                .toUriString();
        
        RequestEntity<Void> req = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        RestTemplate restTemplate  = new RestTemplate();
        ResponseEntity<String> resp;

        String payload = "";
        int statusCode = 0;

        try{
            resp = restTemplate.exchange(req,  String.class);
            payload = resp.getBody();
            statusCode = resp.getStatusCode().value();
        } catch(HttpClientErrorException ex){
            payload = ex.getResponseBodyAsString();
            statusCode = ex.getStatusCode().value();
            return Optional.empty();
        } finally{
            // System.out.printf("URL: %s\n", url);
            // System.out.printf("Payload: %s\n", payload);
            System.out.printf("Status Code: %d\n", statusCode);
        }

        //JsonReader
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject json = reader.readObject();
        
        Currency curr = new Currency();

        curr.setResult(json.getString("result"));
        curr.setTimeLastUpdateUnix(json.getInt("time_last_update_unix"));
        curr.setTimeLastUpdateUTC(json.getString("time_last_update_utc"));
        curr.setTimeNextUpdateUnix(json.getInt("time_next_update_unix"));
        curr.setTimeNextUpdateUTC(json.getString("time_next_update_utc"));
        curr.setBaseCode(json.getString("base_code"));
        curr.setTargetCode(json.getString("target_code"));  
        curr.setConversionRate((float)json.getJsonNumber("conversion_rate").doubleValue());

        // System.out.println(">>>>currency object:" + curr.toString());
        return Optional.of(curr);
    }
}
