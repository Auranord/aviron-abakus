package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.JournalArticleRepository;
import de.aviron.abakus.entities.JournalArticle;

@Service
@AllArgsConstructor
public class JournalArticleService {

    private JournalArticleRepository repository;

    public List<JournalArticle> getAllJournalArticle() {
        return repository.findAll();
    }

    public JournalArticle getJournalArticleById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public JournalArticle addJournalArticle(JournalArticle journalArticle) {
        return repository.save(journalArticle);
    }

    public JournalArticle setJournalArticle(Integer id, JournalArticle journalArticle) {
        return repository.save(journalArticle);
    }

    public JournalArticle updateJournalArticle(JournalArticle journalArticle) {
        JournalArticle oldJournalArticle = repository.findById(journalArticle.getId()).orElse(null);
        if(oldJournalArticle == null)
            return null;
            
        return repository.save(journalArticle);
    }
    
}
