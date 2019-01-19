package com.weatherapi.weatherapi.controller;

import com.weatherapi.weatherapi.model.ZipCodeWeatherResponse;
import com.weatherapi.weatherapi.service.WeatherByZipCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherByZipCodeController {

    private WeatherByZipCodeService weatherByZipCodeService;

    public WeatherByZipCodeController(WeatherByZipCodeService weatherByZipCodeService) {
        this.weatherByZipCodeService = weatherByZipCodeService;
    }


    @GetMapping("/weather-by-zip-code-responses")
    public ResponseEntity<ZipCodeWeatherResponse> retrieveWeatherByZipCode(){

        ZipCodeWeatherResponse zipCodeWeatherResponse = weatherByZipCodeService.retrieveWeatherByZipCode();

        ResponseEntity<ZipCodeWeatherResponse> responseEntity = new ResponseEntity<>(zipCodeWeatherResponse, HttpStatus.OK);

        return responseEntity;
    }

}