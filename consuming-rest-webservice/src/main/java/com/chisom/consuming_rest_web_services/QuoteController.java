package com.chisom.consuming_rest_web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/quotes")
public class QuoteController {


    @GetMapping("")
    public Quote getQuote(RestTemplate restTemplate) throws Exception{
        return restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}
