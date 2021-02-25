package com.example.exchange_rates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GiphyData {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("bitly_gif_url")
    private String bitly_gif_url;

    @JsonProperty("bitly_url")
    private String bitly_url;

    @JsonProperty("embed_url")
    private String embed_url;

    @JsonProperty("title")
    private String title;

}
