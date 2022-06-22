package de.aviron.abakus.controllers;

import java.io.IOException;
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

        // Get User Email from Request Token
        token = controllerUtils.getTokenFromAuthorization(token);
        String userEmail = controllerUtils.getEmailFromToken(token);

        // Get Object by User Email
        User user = service.getUserByEmail(userEmail);

        // Return whole Object
        if(fieldsParam == null) 
            return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user));

        // Return only specified Fields of Object
        List<String> fieldsList = ControllerUtils.getFieldsFromString(fieldsParam);
        return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user, fieldsList));

    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<ObjectNode> getUser(@PathVariable Integer id, @RequestParam(name = "fields", required = false) String fieldsParam) {

        // Get Object by Id
        User user = service.getUserById(id);

        // Return whole Object
        if(fieldsParam == null) 
            return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user));

        // Return only specified Fields of Object
        List<String> fieldsList = ControllerUtils.getFieldsFromString(fieldsParam);
        return ResponseEntity.ok(ControllerUtils.getFieldsFromObject(user, fieldsList));

    }

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<List<ObjectNode>> getAllUsers(@RequestParam(name = "fields", required = false) String fieldsParam) {

        // Get List of all Objects
        List<User> users = service.getAllUsers();

        // Return whole Object List
        if(fieldsParam == null) 
            return ResponseEntity.ok(ControllerUtils.getFieldsFromObjects(users));

        // Return only specified Fields of Object List
        List<String> fieldsList = ControllerUtils.getFieldsFromString(fieldsParam);
        return ResponseEntity.ok(ControllerUtils.getFieldsFromObjects(users, fieldsList));

    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> addUser(@RequestBody User user) {

        // Add new Object
        return ResponseEntity.ok(service.addUser(user));
    }

    @PutMapping(value="/set/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> setUser(@PathVariable Integer id, @RequestBody User user) {

        // Set Object by Id
        return ResponseEntity.ok(service.setUser(id, user));
    }

    @PutMapping(value="/update/{id}")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody ObjectNode objectNode) {

        // Get Object by Id
        User user = service.getUserById(id);

        // Try updating User with Fields from Request Body
        try {
            user = (User)ControllerUtils.updateObject(user, objectNode);
        } catch (IOException e) {
            // On Error return Bad Request
            return ResponseEntity.badRequest().body("request failed");
        }

        // On Success save User and return OK
        service.setUser(id, user);
        return ResponseEntity.ok("success");
    }

    // ???
    @PostMapping(value="/add/{id}/figure")
    @PreAuthorize("hasAuthority('test:test')")
    ResponseEntity<User> addFigure(@PathVariable Integer id, @RequestBody Figure figure) {
        return ResponseEntity.ok(service.addFigure(id, figure));
    }
}
