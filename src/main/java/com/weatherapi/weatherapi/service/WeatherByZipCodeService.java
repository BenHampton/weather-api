package com.weatherapi.weatherapi.service;

import com.weatherapi.weatherapi.client.WeatherByZipCodeClient;
import com.weatherapi.weatherapi.model.ZipCodeWeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherByZipCodeService {

    private WeatherByZipCodeClient weatherByZipCodeClient;

    public WeatherByZipCodeService(WeatherByZipCodeClient weatherByZipCodeClient) {
        this.weatherByZipCodeClient = weatherByZipCodeClient;
    }

    public ZipCodeWeatherResponse retrieveWeatherByZipCode(){

        ZipCodeWeatherResponse zipCodeWeatherResponse = weatherByZipCodeClient.retrieveWeatherByZipCode();

        return zipCodeWeatherResponse;
    }
}