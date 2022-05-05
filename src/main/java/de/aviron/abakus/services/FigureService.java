package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.FigureRepository;
import de.aviron.abakus.entities.Figure;

@Service
@AllArgsConstructor
public class FigureService {

    private FigureRepository repository;

    public List<Figure> getAllFigure() {
        return repository.findAll();
    }

    public Figure getFigureById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Figure addFigure(Figure figure) {
        return repository.save(figure);
    }

    public Figure setFigure(Integer id,Figure figure) {
        return repository.save(figure);
    }

    public Figure updateFigure(Figure figure) {
       Figure oldFigure = repository.findById(figure.getId()).orElse(null);
        if(oldFigure == null)
            return null;
            
        return repository.save(figure);
    }
    
}
