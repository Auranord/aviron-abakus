package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.JournalLetterRepository;
import de.aviron.abakus.entities.JournalLetter;

@Service
@AllArgsConstructor
public class JournalLetterService {

    private JournalLetterRepository repository;

    public List<JournalLetter> getAllJournalLetter() {
        return repository.findAll();
    }

    public JournalLetter getJournalLetterById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public JournalLetter addJournalLetter(JournalLetter journalLetter) {
        return repository.save(journalLetter);
    }

    public JournalLetter setJournalLetter(Integer id, JournalLetter journalLetter) {
        journalLetter.setId(id);
        return repository.save(journalLetter);
    }

    public JournalLetter updateJournalLetter(JournalLetter journalLetter) {
        JournalLetter oldJournalLetter = repository.findById(journalLetter.getId()).orElse(null);
        if(oldJournalLetter == null)
            return null;
            
        return repository.save(journalLetter);
    }
    
}
