package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.aviron.abakus.entities.User;
import de.aviron.abakus.enums.UserRole;
import de.aviron.abakus.repositories.UserRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService {
    
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return repository.findUserByEmail(email).orElse(null);
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User setUser(Integer id, User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        User oldUser = repository.findById(user.getId()).orElse(null);
        if(oldUser == null)
            return null;
            
        return repository.save(user);
    }

    public User setRole(Integer id, UserRole role) {
        User user = repository.findById(id).orElse(null);
        user.setRole(role);
        return repository.save(user);
    }
}
