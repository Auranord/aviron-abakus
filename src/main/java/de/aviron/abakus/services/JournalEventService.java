package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.JournalEventRepository;
import de.aviron.abakus.entities.JournalEvent;

@Service
@AllArgsConstructor
public class JournalEventService {

    private JournalEventRepository repository;

    public List<JournalEvent> getAllJournalEvent() {
        return repository.findAll();
    }

    public JournalEvent getJournalEventById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public JournalEvent addJournalEvent(JournalEvent journalEvent) {
        return repository.save(journalEvent);
    }

    public JournalEvent setJournalEvent(Integer id, JournalEvent journalEvent) {
        return repository.save(journalEvent);
    }

    public JournalEvent updateJournalEvent(JournalEvent journalEvent) {
        JournalEvent oldJournalEvent = repository.findById(journalEvent.getId()).orElse(null);
        if(oldJournalEvent == null)
            return null;
            
        return repository.save(journalEvent);
    }
    
}
