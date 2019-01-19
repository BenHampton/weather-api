package com.weatherapi.weatherapi.service;

import com.weatherapi.weatherapi.client.WeatherApiClient;
import com.weatherapi.weatherapi.model.CurrentWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrentWeatherService {

    private WeatherApiClient weatherApiClient;

    public CurrentWeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public CurrentWeatherResponse executeCurrentWeather(){

        CurrentWeatherResponse currentWeatherResponse = retrieveCurrentWeather();

        return currentWeatherResponse;
    }

    private CurrentWeatherResponse retrieveCurrentWeather(){

        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();

        try {

            currentWeatherResponse = weatherApiClient.retrieveCurrentWeather();

        } catch(Exception e){
            currentWeatherResponse.setErrorMessage(true);
            log.info("Error in retrieveCurrentWeather: " + e.getMessage());
        }

        return currentWeatherResponse;
    }

}
