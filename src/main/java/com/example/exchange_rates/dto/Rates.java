package com.example.exchange_rates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rates {
    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("license")
    private String license;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("base")
    private String base;
    @JsonProperty("rates")
    private Rubs rates;
}
