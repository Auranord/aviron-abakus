package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.JournalCollectionRepository;
import de.aviron.abakus.entities.JournalCollection;

@Service
@AllArgsConstructor
public class JournalCollectionService {

    private JournalCollectionRepository repository;

    public List<JournalCollection> getAllJournalCollection() {
        return repository.findAll();
    }

    public JournalCollection getJournalCollectionById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public JournalCollection addJournalCollection(JournalCollection journalCollection) {
        return repository.save(journalCollection);
    }

    public JournalCollection setJournalCollection(Integer id, JournalCollection journalCollection) {
        journalCollection.setId(id);
        return repository.save(journalCollection);
    }

    public JournalCollection updateJournalCollection(JournalCollection journalCollection) {
        JournalCollection oldJournalCollection = repository.findById(journalCollection.getId()).orElse(null);
        if(oldJournalCollection == null)
            return null;
            
        return repository.save(journalCollection);
    }
    
}
