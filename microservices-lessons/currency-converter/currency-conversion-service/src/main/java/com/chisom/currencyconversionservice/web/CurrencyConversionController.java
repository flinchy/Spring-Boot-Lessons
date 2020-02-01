package com.chisom.currencyconversionservice.web;

import com.chisom.currencyconversionservice.payload.CurrencyConversionBean;
import com.chisom.currencyconversionservice.service.CurrencyConversionService;
import com.chisom.currencyconversionservice.service.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    CurrencyConversionService currencyConversionService;

    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        return currencyConversionService.retrieveCurrencyConverter(from, to, quantity);
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
        log.info("{}", response);

        return new CurrencyConversionBean(
                response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
