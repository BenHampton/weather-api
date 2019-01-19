package com.weatherapi.weatherapi.client;


import com.weatherapi.weatherapi.model.CurrentWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class WeatherApiClient {

    private RestTemplate restTemplate;

    private final String apiKey = "c478384e412c63529711f246ef95def0";

    private final String cityId = "4407066";

    private String apiUrl = "http://api.openweathermap.org/data/2.5/weather";

    private String URL = apiUrl+"?id="+cityId+"&appid="+apiKey;

    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrentWeatherResponse retrieveCurrentWeather(){

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CurrentWeatherResponse> entity = new HttpEntity<>(headers);
            log.info("retrieve current weather request: " + URL);
            ResponseEntity<CurrentWeatherResponse> response = restTemplate.exchange(URL, HttpMethod.GET, entity, CurrentWeatherResponse.class);

            CurrentWeatherResponse currentWeatherResponse = response.getBody();
            log.info("Response: " + response.getBody());

            return currentWeatherResponse;
        } catch (Exception e){
            log.info("Error: " + e.getMessage());
        }

        return null;
    }
}