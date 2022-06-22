package de.aviron.abakus.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.aviron.abakus.services.FigureService;
import lombok.AllArgsConstructor;
import de.aviron.abakus.entities.Figure;

@RestController
@RequestMapping("/abakus/figure")
@AllArgsConstructor
public class FigureController {

    private FigureService service;

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<List<Figure>> getAllFigures() {
        return ResponseEntity.ok(service.getAllFigure());
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<Figure> getFigure(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFigureById(id));
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<Figure> addFigure(@RequestBody Figure figure) {
        return ResponseEntity.ok(service.addFigure(figure));
    }

    @PutMapping(value="/set/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<Figure> setFigure(@PathVariable Integer id, @RequestBody Figure figure) {
        return ResponseEntity.ok(service.setFigure(id, figure));
    }

    @PutMapping(value="/update")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<Figure> updateFigure(@RequestBody Figure figure) {
        return ResponseEntity.ok(service.updateFigure(figure));
    }

}
