package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.aviron.abakus.repositories.FigureRepository;
import lombok.AllArgsConstructor;
import de.aviron.abakus.entities.Figure;

@Service
@AllArgsConstructor
public class FigureService {
    
    private FigureRepository repository;

    public List<Figure> getAllCharacters() {
        return repository.findAll();
    }

    public Figure getCharacter(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Figure addCharacter(Figure character) {
        return repository.save(character);
    }

    public Figure setCharacter(Integer id, Figure character) {
        Figure oldCharacter = repository.findById(id).orElse(null);
        oldCharacter.setOwner(character.getOwner());
        oldCharacter.setName(character.getName());
        return repository.save(oldCharacter);
    }

}
