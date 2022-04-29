package de.aviron.abakus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
    private String page = "<h1>Hello World</h1>";

    @GetMapping("/")
    public String helloWorldRoot() {
        return page;
    }

    @GetMapping("/index")
    public String helloWorldIndex() {
        return page;
    }

}
