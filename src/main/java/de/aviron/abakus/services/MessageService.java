package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.MessageRepository;
import de.aviron.abakus.entities.Message;

@Service
@AllArgsConstructor
public class MessageService {

    private MessageRepository repository;

    public List<Message> getAllMessage() {
        return repository.findAll();
    }

    public Message getMessageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Message addMessage(Message message) {
        return repository.save(message);
    }

    public Message setMessage(Integer id, Message message) {
        return repository.save(message);
    }

    public Message updateMessage(Message message) {
        Message oldMessage = repository.findById(message.getId()).orElse(null);
        if(oldMessage == null)
            return null;
            
        return repository.save(message);
    }
    
}
