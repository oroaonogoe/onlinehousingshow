package com.example.onlinehousingshow.controller;

import com.example.onlinehousingshow.dto.LoginDTO;
import com.example.onlinehousingshow.model.Owner;
import com.example.onlinehousingshow.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Owner> registerOwner(Owner owner) {
        return new ResponseEntity<>(authenticationService.registerOwner(owner), HttpStatus.OK);
    }

    @PostMapping("/login")
    public LoginDTO loginOwner(@RequestBody Owner owner) {
        return authenticationService.loginOwner(owner.getUsername(), owner.getPassword());
    }

}
