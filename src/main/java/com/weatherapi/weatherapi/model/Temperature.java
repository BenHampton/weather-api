package com.weatherapi.weatherapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Temperature {

    private String humidity;

    @JsonProperty("temp")
    private String temperature;

    @JsonProperty("temp_min")
    private String temperatureMin;

    @JsonProperty("temp_max")
    private String temperatureMax;

}
