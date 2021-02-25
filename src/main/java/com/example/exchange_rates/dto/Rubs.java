package com.example.exchange_rates.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rubs {

    @JsonProperty("RUB")
    private Double rub;
}
