package de.aviron.abakus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.aviron.abakus.entities.User;
import de.aviron.abakus.services.UserService;
import lombok.AllArgsConstructor;


@RestController                 // TODO: only use ResponeEntity as return
@RequestMapping("/abakus/user")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('user:read')")
    List<User> getAllCharacters() {
        return service.getAllUsers();
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    User getCharacter(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('user:write')")
    User addCharacter(@RequestBody User user) {
        return service.addUser(user);
    }

    @PutMapping(value="/set")
    @PreAuthorize("hasAuthority('user:write')")
    User setCharacter(@PathVariable Integer id, @RequestBody User character) {
        return service.setUser(id, character);
    }

}
