package com.iiitb.tutorhunt.Controller;

import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/Hello"})
public class HelloWorld {

    @GetMapping("/hello")
    public String firstpage(){
        return "Hello World";
    }

}
