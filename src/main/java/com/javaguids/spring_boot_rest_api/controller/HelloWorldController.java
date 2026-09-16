package com.javaguids.spring_boot_rest_api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

    //HTTP GET REQUEST
    @GetMapping("/hello-world")
    public String helloworld(){
        return "Hello World";
    }
}
