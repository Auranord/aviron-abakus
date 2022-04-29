package de.aviron.abakus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.aviron.abakus.entities.User;
import de.aviron.abakus.repositories.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User setUser(Integer id, User user) {
        User oldUser = repository.findById(id).orElse(null);
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return repository.save(oldUser);
    }

}
