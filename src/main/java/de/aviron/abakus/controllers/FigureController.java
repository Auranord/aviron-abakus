package de.aviron.abakus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.aviron.abakus.services.FigureService;
import de.aviron.abakus.entities.Figure;

@RestController
@RequestMapping("/abakus/figure")
public class FigureController {
    
    @Autowired
    private FigureService service;

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('figure:read')")
    List<Figure> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('figure:read')")
    Figure getCharacter(@PathVariable Integer id) {
        return service.getCharacter(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('figure:write')")
    Figure addCharacter(@RequestBody Figure character) {
        return service.addCharacter(character);
    }

    @PutMapping(value="/set/{id}")
    @PreAuthorize("hasAuthority('figure:write')")
    Figure setCharacter(@PathVariable Integer id, @RequestBody Figure character) {
        return service.setCharacter(id, character);
    }


}
