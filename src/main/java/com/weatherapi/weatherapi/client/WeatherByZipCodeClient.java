package com.weatherapi.weatherapi.client;

import com.weatherapi.weatherapi.model.ZipCodeWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class WeatherByZipCodeClient {

    private final String URL = "http://api.openweathermap.org/data/2.5/forecast?zip=63128,us&appid=c478384e412c63529711f246ef95def0";

    private final String apiKey = "c478384e412c63529711f246ef95def0";

    private final String country = "us";

    private final String zipCode = "63128";

    private final String apiUrl = URL + "?zip=" + zipCode + "," + country + "&appid=" + apiKey;

    private RestTemplate restTemplate;

    public WeatherByZipCodeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ZipCodeWeatherResponse retrieveWeatherByZipCode(){

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<ZipCodeWeatherResponse> httpEntity = new HttpEntity<>(headers);

            log.info("Request for weatherByZipCode: " + URL + "?zip=" + zipCode + "," + country + "&appid=" + apiKey);
            ResponseEntity<ZipCodeWeatherResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, ZipCodeWeatherResponse.class);
            log.info("Response from WeatherByZipCode : " + responseEntity.getBody() );

            ZipCodeWeatherResponse zipCodeWeatherResponse = responseEntity.getBody();

            return zipCodeWeatherResponse;

        } catch (Exception e){
            log.info("Exception Caught: " + e.getMessage());

        }

        return null;
    }
}
