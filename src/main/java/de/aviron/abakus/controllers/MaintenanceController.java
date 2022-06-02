package de.aviron.abakus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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

}
