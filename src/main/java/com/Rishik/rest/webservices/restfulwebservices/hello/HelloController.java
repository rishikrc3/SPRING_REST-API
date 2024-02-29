package com.Rishik.rest.webservices.restfulwebservices.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping(path="/hello")
    public String sayHi()
    {
        return "Good Morning from Spring Boot!";
    }
}
