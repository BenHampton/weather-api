package com.weatherapi.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sun {

    @JsonProperty("sunrise")
    private String sunRise;

    @JsonProperty("sunset")
    private String sunSet;
}
