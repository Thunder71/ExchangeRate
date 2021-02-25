package com.example.exchange_rates.service;

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
class RateServiceTest {

    @Autowired
    private RateService rateService;

    @MockBean
    private RatesClient ratesClient;


    @Test
    void getRates() {
        Rates rates = new Rates();
        Rubs rubs = new Rubs();
        rubs.setRub(73.7975);
        rates.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        rates.setLicense("https://openexchangerates.org/license");
        rates.setTimestamp(1614258000);
        rates.setBase("USD");
        rates.setRates(rubs);

        Mockito.doReturn(rates)
                .when(ratesClient)
                .getRates(ArgumentMatchers.anyString());

        Rates rates1 = rateService.getRates(ArgumentMatchers.anyString());
        Assert.assertNotNull(rates1);
        Mockito.verify(ratesClient, Mockito.times(1)).getRates(ArgumentMatchers.anyString());
    }

    @Test
    void getRatesNull() {

        Mockito.doReturn(null)
                .when(ratesClient)
                .getRates(ArgumentMatchers.anyString());

        Rates rates1 = rateService.getRates(ArgumentMatchers.anyString());
        Assert.assertNull(rates1);
        Mockito.verify(ratesClient, Mockito.times(1)).getRates(ArgumentMatchers.anyString());
    }
}