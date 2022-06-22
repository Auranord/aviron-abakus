package de.aviron.abakus.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {
    
    @GetMapping("/health")
    public String health() {
        return "\"health\": \"ok\"";
    }

    // TODO
    @GetMapping("/latenz")
    public String latenz() {
        return "\"latenz\": 0";
    }

    @GetMapping("/test")
    public Map<String,String> test(@RequestParam Map<String,String> allParams) {
        return allParams;
    }

}
