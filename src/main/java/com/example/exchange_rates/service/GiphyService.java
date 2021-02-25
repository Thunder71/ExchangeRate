package com.example.exchange_rates.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@Component
public class GiphyService {

    private final RateService rateService;

    public RedirectView getGiphyDate(String appId, String giph_id){

        return new RedirectView(rateService.valueRates(appId, giph_id));
    }

    public RedirectView getGiphyDateValute(String valute, String appId, String giph_id){

        return new RedirectView(rateService.valueValuteTrates(valute, appId, giph_id));
    }

}
