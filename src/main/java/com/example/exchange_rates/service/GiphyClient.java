package com.example.exchange_rates.service;

import com.example.exchange_rates.dto.Giphy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "giphy-client", url = "https://api.giphy.com/v1/gifs")
public interface GiphyClient {

    @GetMapping("/random?api_key={appId}&tag=rich&rating=g")
    Giphy getRandomGiphyRich(@PathVariable  String appId);

    @GetMapping("/random?api_key={appId}&tag=broke&rating=g")
    Giphy getRandonGiphyBroke(@PathVariable String appId);
}
