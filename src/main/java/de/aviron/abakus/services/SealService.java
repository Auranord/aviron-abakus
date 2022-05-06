package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.SealRepository;
import de.aviron.abakus.entities.Seal;

@Service
@AllArgsConstructor
public class SealService {

    private SealRepository repository;

    public List<Seal> getAllSeal() {
        return repository.findAll();
    }

    public Seal getSealById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Seal addSeal(Seal seal) {
        return repository.save(seal);
    }

    public Seal setSeal(Integer id, Seal seal) {
        seal.setId(id);
        return repository.save(seal);
    }

    public Seal updateSeal(Seal seal) {
        Seal oldSeal = repository.findById(seal.getId()).orElse(null);
        if(oldSeal == null)
            return null;
            
        return repository.save(seal);
    }
    
}
