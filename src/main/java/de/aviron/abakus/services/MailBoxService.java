package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.MailBoxRepository;
import de.aviron.abakus.entities.MailBox;

@Service
@AllArgsConstructor
public class MailBoxService {

    private MailBoxRepository repository;

    public List<MailBox> getAllMailBox() {
        return repository.findAll();
    }

    public MailBox getMailBoxById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public MailBox addMailBox(MailBox mailBox) {
        return repository.save(mailBox);
    }

    public MailBox setMailBox(Integer id, MailBox mailBox) {
        mailBox.setId(id);
        return repository.save(mailBox);
    }

    public MailBox updateMailBox(MailBox mailBox) {
        MailBox oldMailBox = repository.findById(mailBox.getId()).orElse(null);
        if(oldMailBox == null)
            return null;
            
        return repository.save(mailBox);
    }
    
}
