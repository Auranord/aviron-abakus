package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.JournalIssueRepository;
import de.aviron.abakus.entities.JournalIssue;

@Service
@AllArgsConstructor
public class JournalIssueService {

    private JournalIssueRepository repository;

    public List<JournalIssue> getAllJournalIssue() {
        return repository.findAll();
    }

    public JournalIssue getJournalIssueById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public JournalIssue addJournalIssue(JournalIssue journalIssue) {
        return repository.save(journalIssue);
    }

    public JournalIssue setJournalIssue(Integer id, JournalIssue journalIssue) {
        journalIssue.setId(id);
        return repository.save(journalIssue);
    }

    public JournalIssue updateJournalIssue(JournalIssue journalIssue) {
        JournalIssue oldJournalIssue = repository.findById(journalIssue.getId()).orElse(null);
        if(oldJournalIssue == null)
            return null;
            
        return repository.save(journalIssue);
    }
    
}
