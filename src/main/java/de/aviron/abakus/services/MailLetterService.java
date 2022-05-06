package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.MailLetterRepository;
import de.aviron.abakus.entities.MailLetter;

@Service
@AllArgsConstructor
public class MailLetterService {

    private MailLetterRepository repository;

    public List<MailLetter> getAllMailLetter() {
        return repository.findAll();
    }

    public MailLetter getMailLetterById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public MailLetter addMailLetter(MailLetter mailLetter) {
        return repository.save(mailLetter);
    }

    public MailLetter setMailLetter(Integer id, MailLetter mailLetter) {
        mailLetter.setId(id);
        return repository.save(mailLetter);
    }

    public MailLetter updateMailLetter(MailLetter mailLetter) {
        MailLetter oldMailLetter = repository.findById(mailLetter.getId()).orElse(null);
        if(oldMailLetter == null)
            return null;
            
        return repository.save(mailLetter);
    }
    
}
