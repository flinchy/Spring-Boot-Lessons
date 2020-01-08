package com.chisom.spring_security_jwt_RBA.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @GetMapping("/all")
    public String hello() {
        return "Hello youtube";
    }

    @GetMapping("/secured/all")
    public String securedHello() {
        return "Welcome to the secured page saying hello";
    }
}
