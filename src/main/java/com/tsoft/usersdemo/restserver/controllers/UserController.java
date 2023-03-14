package com.tsoft.usersdemo.restserver.controllers;

import com.tsoft.usersdemo.configuration.security.JwtManager;
import com.tsoft.usersdemo.entities.User;
import com.tsoft.usersdemo.repositories.UserRepository;
import com.tsoft.usersdemo.restserver.dtos.CreateUserDto;
import com.tsoft.usersdemo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    public ResponseEntity<User>createUser(@Valid @RequestBody CreateUserDto user){
        User newUser = this.userService.createUser(user.toUser());
        String token = JwtManager.createToken(newUser);
        newUser.setToken(token);
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
