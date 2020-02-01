package com.chisom.currencyconversionservice.service;

import com.chisom.currencyconversionservice.payload.CurrencyConversionBean;

import java.math.BigDecimal;

public interface CurrencyConversionService {

    CurrencyConversionBean retrieveCurrencyConverter(String from, String to, BigDecimal quantity);
}
