package com.chisom.currencyconversionservice.service;

import com.chisom.currencyconversionservice.payload.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService{

    private static final Logger log = LoggerFactory.getLogger(CurrencyConversionServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    public CurrencyConversionBean retrieveCurrencyConverter(String from, String to, BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> currencyConversionBean = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);


        CurrencyConversionBean response = currencyConversionBean.getBody();
        log.info("Retrieving info from the forex service {}", response.toString());

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
