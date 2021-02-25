package com.example.exchange_rates.controller;

import com.example.exchange_rates.dto.Rates;
import com.example.exchange_rates.service.GiphyService;
import com.example.exchange_rates.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {

    private final RateService rateService;
    private final GiphyService giphyService;

    @GetMapping("/getRates/APP_ID={appId}")
    public Rates getRates(@PathVariable String appId){
        return rateService.getRates(appId);
    }

    @GetMapping("/getRatesFromDate/DATE={date}/APP_ID={appId}")
    public Rates getRateFromDate(@PathVariable String date, @PathVariable String appId){
        return rateService.getRatesFromDate(date, appId);
    }

    @GetMapping("/getRatesFromValute/VALUTE={valute}/APP_ID={appID}")
    public Rates getRateFromValute(@PathVariable String valute, @PathVariable String appId){
        return rateService.getRatesFromValute(valute, appId);
    }

    @GetMapping("/getRatesFromValuteAndDate/VALUTE={valute}/DATE={date}/APP_ID={appId}")
    public Rates getRateFromValuteAndDate(@PathVariable String valute, @PathVariable String date, @PathVariable String appId){
        return rateService.getRatesFromValuteAndDate(valute, date, appId);
    }

    @GetMapping("/getValuteRates/VALUTES={valute}/APP_ID={appId}/GIPH_ID={giphId}")
    public RedirectView getValueFromDateAndValute(@PathVariable String valute, @PathVariable String appId, @PathVariable String giphId){
        return giphyService.getGiphyDateValute(valute, appId, giphId);
    }

    @GetMapping("/getValueRates/APP_ID={appId}/GIPH_ID={giphId}")
    public RedirectView getValueRates(@PathVariable String appId, @PathVariable String giphId) {
        return giphyService.getGiphyDate(appId, giphId);
    }
}
