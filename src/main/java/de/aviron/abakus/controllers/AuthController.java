package de.aviron.abakus.controllers;

import de.aviron.abakus.entities.User;
import de.aviron.abakus.enums.ErrorMessage;
import de.aviron.abakus.requests.AuthRequest;
import de.aviron.abakus.security.JwtTokenProvider;
import de.aviron.abakus.services.UserService;
import de.aviron.abakus.utils.ErrorProvider;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> RegisterUser(@RequestBody AuthRequest authRequest) {
        User presentUser = userService.getUserByEmail(authRequest.getEmail());

        if (presentUser != null) {
            return ResponseEntity.ok(ErrorProvider.getNode(ErrorMessage.USER_EXISTS));
        }

        User user = new User();
        user.setEmail(authRequest.getEmail());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));

        User created = userService.addUser(user);

        return ResponseEntity.ok(created);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> LoginUser(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
            );
            return ResponseEntity.ok( "{ \"token\": \"" + jwtTokenProvider.generateToken(authentication) + "\" }");
        } catch (AuthenticationException e) {
            return ResponseEntity.ok(ErrorProvider.getNode(ErrorMessage.LOGIN_FAILED));
        }
    }

}
