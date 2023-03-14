package com.tsoft.usersdemo.restserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/")
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("lacra", HttpStatus.ACCEPTED);
    }
}
