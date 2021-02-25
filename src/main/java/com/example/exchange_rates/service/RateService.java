package com.example.exchange_rates.service;

import com.example.exchange_rates.dto.Rates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class RateService {


    private final RatesClient ratesClient;
    private final ValueDateComp valueDateComp;
    private final ValidateRates validateRates;

    public Rates getRates(String appId){
        return ratesClient.getRates(appId);
    }

    public Rates getRatesFromDate(String date, String appId){
        return ratesClient.getRatesFromDate(date, appId);
    }

    public Rates getRatesFromValute(String valute, String appId){
        return ratesClient.getRatesValute(valute, appId);
    }

    public Rates getRatesFromValuteAndDate(String valute, String date, String appId){
        return ratesClient.getRatesFromDateAndValute(valute, date, appId);
    }

    public String valueRates(String appId, String giphId){
        String date = valueDateComp.getDate();
        return validateRates.validateValut(ratesClient.getRates(appId), ratesClient.getRatesFromDate(date, appId), giphId);
    }

    public String valueValuteTrates(String valute, String appId, String giphId){
        String date = valueDateComp.getDate();
        return validateRates.validateValut(ratesClient.getRatesValute(valute, appId), ratesClient.getRatesFromDateAndValute(valute, date, appId), giphId);
    }
}
