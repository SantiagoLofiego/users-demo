package com.tsoft.usersdemo.restserver.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsoft.usersdemo.entities.Phone;
import com.tsoft.usersdemo.entities.User;

import java.time.LocalDateTime;
import java.util.List;


public class UserDto {
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phones = user.getPhones();
        this.created = user.getCreated();
        this.modified = user.getModified();
        this.lastLogin = user.getLastLogin();
        this.isActive = user.isActive();
        this.token = user.getToken();
    }

    private String id;
    private String name;
    private String email;
    private List<Phone> phones;
    @JsonFormat(pattern = "ccc dd-MM-YYYY HH:mm:ss ")
    private LocalDateTime created;
    @JsonFormat(pattern = "ccc dd-MM-YYYY HH:mm:ss ")
    private LocalDateTime modified;
    @JsonFormat(pattern = "ccc dd-MM-YYYY HH:mm:ss ")
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
