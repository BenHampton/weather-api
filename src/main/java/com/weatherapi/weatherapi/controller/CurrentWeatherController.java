package com.weatherapi.weatherapi.controller;

import com.weatherapi.weatherapi.model.CurrentWeatherResponse;
import com.weatherapi.weatherapi.service.CurrentWeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentWeatherController {

    private CurrentWeatherService currentWeatherService;

    public CurrentWeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @GetMapping("/cities-current-weather-responses")
    public ResponseEntity<CurrentWeatherResponse> retrieveCurrentWeatherByCityId(){

        ResponseEntity responseEntity = null;

        CurrentWeatherResponse currentWeatherResponse = currentWeatherService.executeCurrentWeather();

        responseEntity = new ResponseEntity<>(currentWeatherResponse, HttpStatus.OK);

        return responseEntity;
    }

}