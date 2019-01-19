package com.weatherapi.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {

    @JsonProperty("main")
    private String weatherCondition;

    @JsonProperty("description")
    private String conditionDescription;

}
