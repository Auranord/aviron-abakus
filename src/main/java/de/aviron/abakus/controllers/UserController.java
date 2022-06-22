package de.aviron.abakus.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import de.aviron.abakus.entities.Figure;
import de.aviron.abakus.entities.User;
import de.aviron.abakus.services.UserService;
import de.aviron.abakus.utils.ControllerUtils;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/abakus/user")
@AllArgsConstructor
public class UserController {

    private UserService service;
    private ControllerUtils controllerUtils;

    @GetMapping(value="/")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<ObjectNode> getOwnUsers(@RequestHeader (name="Authorization") String token, @RequestParam(name = "fields", required = false) String fieldsParam) {

        token = controllerUtils.getTokenFromAuthorization(token);
        String userEmail = controllerUtils.getEmailFromToken(token);

        User user = service.getUserByEmail(userEmail);

        if(fieldsParam == null) 
            return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user));

        List<String> fieldsList = ControllerUtils.getFieldsFromString(fieldsParam);
        return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user, fieldsList));

    }

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<List<ObjectNode>> getAllUsers(@RequestParam(name = "fields", required = false) String fieldsParam) {

        List<User> users = service.getAllUsers();

        if(fieldsParam == null) 
            return ResponseEntity.ok(ControllerUtils.getFieldsFromObjects(users));

        List<String> fieldsList = ControllerUtils.getFieldsFromString(fieldsParam);
        return ResponseEntity.ok(ControllerUtils.getFieldsFromObjects(users, fieldsList));

    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<ObjectNode> getUser(@PathVariable Integer id, @RequestParam(name = "fields", required = false) String fieldsParam) {

        User user = service.getUserById(id);

        if(fieldsParam == null) 
            return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user));

        List<String> fieldsList = ControllerUtils.getFieldsFromString(fieldsParam);
        return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user, fieldsList));

    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(service.addUser(user));
    }

    @PutMapping(value="/set/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> setUser(@PathVariable Integer id, @RequestBody User user) {
        return ResponseEntity.ok(service.setUser(id, user));
    }

    @PutMapping(value="/update")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(service.updateUser(user));
    }

    @PostMapping(value="/add/{id}/figure")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> addFigure(@PathVariable Integer id, @RequestBody Figure figure) {
        return ResponseEntity.ok(service.addFigure(id, figure));
    }
}
