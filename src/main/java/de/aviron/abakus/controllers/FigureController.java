package de.aviron.abakus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.aviron.abakus.services.FigureService;
import de.aviron.abakus.entities.Figure;

@RestController
public class FigureController {
    
    @Autowired
    private FigureService service;

    @GetMapping(value="/abakus/chars")
    List<Figure> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping(value="/abakus/chars/{id}")
    Figure getCharacter(@PathVariable Integer id) {
        return service.getCharacter(id);
    }

    @PostMapping(value="/abakus/chars/add")
    Figure addCharacter(@RequestBody Figure character) {
        return service.addCharacter(character);
    }

    @PutMapping(value="/abakus/{id}/set")
    Figure setCharacter(@PathVariable Integer id, @RequestBody Figure character) {
        return service.setCharacter(id, character);
    }


}
