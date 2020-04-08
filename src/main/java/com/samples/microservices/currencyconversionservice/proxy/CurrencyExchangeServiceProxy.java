package com.samples.microservices.currencyconversionservice.proxy;

import com.samples.microservices.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RibbonClient("currency-exchange-service")
@FeignClient(name="zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to);
}
