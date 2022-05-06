package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.SigningRepository;
import de.aviron.abakus.entities.Signing;

@Service
@AllArgsConstructor
public class SigningService {

    private SigningRepository repository;

    public List<Signing> getAllSigning() {
        return repository.findAll();
    }

    public Signing getSigningById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Signing addSigning(Signing signing) {
        return repository.save(signing);
    }

    public Signing setSigning(Integer id, Signing signing) {
        signing.setId(id);
        return repository.save(signing);
    }

    public Signing updateSigning(Signing signing) {
        Signing oldSigning = repository.findById(signing.getId()).orElse(null);
        if(oldSigning == null)
            return null;
            
        return repository.save(signing);
    }
    
}
