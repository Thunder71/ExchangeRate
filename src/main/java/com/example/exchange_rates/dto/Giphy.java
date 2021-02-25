package com.example.exchange_rates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Giphy {

    @JsonProperty("data")
    GiphyData giphyData;
}
