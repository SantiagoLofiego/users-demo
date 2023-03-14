package com.tsoft.usersdemo.services;

import com.tsoft.usersdemo.entities.User;
import com.tsoft.usersdemo.exceptions.EmailAlreadyRegistered;
import com.tsoft.usersdemo.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    private UserServiceImp userService = new UserServiceImp();

    @Test
    public void createUserTest() {
        User user = new User();
        user.setEmail("prueba@gmail.com");
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);
        String result = userService.createUser(user).getEmail();
        assertEquals("prueba@gmail.com", result);
    }
    @Test
    public void createUserFailTest() {
        User user = new User();
        user.setEmail("prueba@gmail.com");
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        EmailAlreadyRegistered ex = assertThrows(EmailAlreadyRegistered.class,()-> userService.createUser(user));
        assertEquals("Email " +user.getEmail() +" already registered", ex.getMessage());
    }
}