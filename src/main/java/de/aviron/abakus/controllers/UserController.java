package de.aviron.abakus.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.aviron.abakus.entities.Figure;
import de.aviron.abakus.entities.User;
import de.aviron.abakus.security.JwtTokenProvider;
import de.aviron.abakus.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/abakus/user")
@AllArgsConstructor
public class UserController {

    private UserService service;
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping(value="/")
    ResponseEntity<User> getOwnUsers(@RequestHeader (name="Authorization") String token) {

        // TODO: create utils class
        if (StringUtils.hasText(token) && token.startsWith("Bearer "))
            token = token.substring(7);

        // TODO: create utils class
        if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token))
            return ResponseEntity.ok(service.getUserByEmail(jwtTokenProvider.getUserMailFromToken(token)));

        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('user:read')")
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    ResponseEntity<User> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(service.addUser(user));
    }

    @PutMapping(value="/set/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<User> setUser(@PathVariable Integer id, @RequestBody User character) {
        return ResponseEntity.ok(service.setUser(id, character));
    }

    @PutMapping(value="/update")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<User> setUser(@RequestBody User character) {
        return ResponseEntity.ok(service.updateUser(character));
    }

    @PostMapping(value="/add/{id}/figure")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<User> addFigure(@PathVariable Integer id, @RequestBody Figure figure) {
        return ResponseEntity.ok(service.addFigure(id, figure));
    }
}
