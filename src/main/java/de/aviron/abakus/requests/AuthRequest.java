package de.aviron.abakus.requests;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;

}
