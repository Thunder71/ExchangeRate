package com.example.exchange_rates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExchangeRatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeRatesApplication.class, args);
	}

}
