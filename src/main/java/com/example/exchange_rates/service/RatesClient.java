package com.example.exchange_rates.service;

import com.example.exchange_rates.dto.Rates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "oxr-client", url = "https://openexchangerates.org/api")
public interface RatesClient {

    @GetMapping("/latest.json?app_id={appId}")
    Rates getRates(@PathVariable String appId);

    @GetMapping("/latest.json?app_id={appId}&base={valute}")
    Rates getRatesValute(@PathVariable String valute, @PathVariable String appId);

    @GetMapping("/historical/{date}.json?app_id={appId}")
    Rates getRatesFromDate(@PathVariable String date, @PathVariable String appId);

    @GetMapping("/historical/{date}.json?app_id={appId}&base={valute}")
    Rates getRatesFromDateAndValute(@PathVariable String valute, @PathVariable String date, @PathVariable String appId);
}
