package com.example.exchange_rates.service;

import com.example.exchange_rates.dto.Giphy;
import com.example.exchange_rates.dto.GiphyData;
import com.example.exchange_rates.dto.Rates;
import com.example.exchange_rates.dto.Rubs;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ValidateRatesTest {

    @Autowired
    private ValidateRates validateRates;

    @MockBean
    private GiphyClient giphyClient;

    @Test
    void validateValutToRich() {
        Rates rates = new Rates();
        Rubs rubs = new Rubs();
        rubs.setRub(73.7975);
        rates.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        rates.setLicense("https://openexchangerates.org/license");
        rates.setTimestamp(1614258000);
        rates.setBase("USD");
        rates.setRates(rubs);
        Rates rates1 = new Rates();
        Rubs rubs1 = new Rubs();
        rubs1.setRub(73.524);
        rates1.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        rates1.setLicense("https://openexchangerates.org/license");
        rates1.setTimestamp(1614211199);
        rates1.setBase("USD");
        rates1.setRates(rubs1);

        Giphy giphy = new Giphy();
        GiphyData giphyData = new GiphyData();
        giphyData.setType("gif");
        giphyData.setId("xT1Ra4oxfzRsr2YrWE");
        giphyData.setUrl("https://giphy.com/gifs/indonesia-rich-kaya-xT1Ra4oxfzRsr2YrWE");
        giphyData.setSlug("indonesia-rich-kaya-xT1Ra4oxfzRsr2YrWE");
        giphyData.setBitly_gif_url("https://gph.is/2h5dIkI");
        giphyData.setBitly_url("https://gph.is/2h5dIkI");
        giphyData.setEmbed_url("https://giphy.com/embed/xT1Ra4oxfzRsr2YrWE");
        giphyData.setTitle("Animated GIF");
        giphy.setGiphyData(giphyData);

        Mockito.doReturn(giphy)
                .when(giphyClient)
                .getRandomGiphyRich("yrqZxczIaZx9uTmWsJ7CwQ9oRmoqySxY");


        String url = validateRates.validateValut(rates, rates1, "yrqZxczIaZx9uTmWsJ7CwQ9oRmoqySxY");

        assertNotNull(url);
        Mockito.verify(giphyClient, Mockito.times(1)).getRandomGiphyRich(ArgumentMatchers.anyString());
    }

    @Test
    void validateValutToBroke() {
        Rates rates = new Rates();
        Rubs rubs = new Rubs();
        rubs.setRub(73.524);
        rates.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        rates.setLicense("https://openexchangerates.org/license");
        rates.setTimestamp(1614258000);
        rates.setBase("USD");
        rates.setRates(rubs);
        Rates rates1 = new Rates();
        Rubs rubs1 = new Rubs();
        rubs1.setRub(73.7975);
        rates1.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        rates1.setLicense("https://openexchangerates.org/license");
        rates1.setTimestamp(1614211199);
        rates1.setBase("USD");
        rates1.setRates(rubs1);

        Giphy giphy = new Giphy();
        GiphyData giphyData = new GiphyData();
        giphyData.setType("gif");
        giphyData.setId("xT1Ra4oxfzRsr2YrWE");
        giphyData.setUrl("https://giphy.com/gifs/indonesia-rich-kaya-xT1Ra4oxfzRsr2YrWE");
        giphyData.setSlug("indonesia-rich-kaya-xT1Ra4oxfzRsr2YrWE");
        giphyData.setBitly_gif_url("https://gph.is/2h5dIkI");
        giphyData.setBitly_url("https://gph.is/2h5dIkI");
        giphyData.setEmbed_url("https://giphy.com/embed/xT1Ra4oxfzRsr2YrWE");
        giphyData.setTitle("Animated GIF");
        giphy.setGiphyData(giphyData);

        Mockito.doReturn(giphy)
                .when(giphyClient)
                .getRandonGiphyBroke("yrqZxczIaZx9uTmWsJ7CwQ9oRmoqySxY");


        String url = validateRates.validateValut(rates, rates1, "yrqZxczIaZx9uTmWsJ7CwQ9oRmoqySxY");

        Assert.assertNotNull(url);

        Mockito.verify(giphyClient, Mockito.times(1)).getRandonGiphyBroke(ArgumentMatchers.anyString());
    }

}