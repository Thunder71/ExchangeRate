package com.example.exchange_rates.service;

import com.example.exchange_rates.dto.Rates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ValidateRates {

    private final GiphyClient giphyClient;

    public String validateValut(Rates rates1, Rates rates2, String giphId){

        if (rates1.getRates().getRub() > rates2.getRates().getRub()){

            return giphyClient.getRandomGiphyRich(giphId).getGiphyData().getEmbed_url();
        }else
        if (rates1.getRates().getRub() < rates2.getRates().getRub()){

            return giphyClient.getRandonGiphyBroke(giphId).getGiphyData().getEmbed_url();
        }
        else {
            return giphyClient.getRandonGiphyBroke(giphId).getGiphyData().getEmbed_url();
        }
    }
}
