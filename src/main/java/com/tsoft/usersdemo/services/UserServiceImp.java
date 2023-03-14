package com.tsoft.usersdemo.services;

import com.tsoft.usersdemo.entities.User;
import com.tsoft.usersdemo.exceptions.EmailAlreadyRegistered;
import com.tsoft.usersdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        boolean alreadyRegistered = !userRepository.findByEmail(user.getEmail()).isEmpty();
        if(alreadyRegistered){
            throw new EmailAlreadyRegistered("Email " +user.getEmail() +" already registered");
        }
        User newUser = userRepository.save(user);
        return newUser;
    }
}
