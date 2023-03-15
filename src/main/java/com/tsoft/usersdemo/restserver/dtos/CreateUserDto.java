package com.tsoft.usersdemo.restserver.dtos;

import com.tsoft.usersdemo.entities.Phone;
import com.tsoft.usersdemo.entities.User;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "Name required")
    private String name;
    @NotNull(message = "Password required")
    @Pattern(regexp = "(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d.*\\d)[a-zA-Z\\d/@$!%*?&]{8,}$)"
            , message = "The password must contain at least one uppercase one lowercase letter and two numbers")
    private String password;
    @NotEmpty
    @Pattern(regexp = "^[a-z]{3,}@[a-z]{3,}(\\.[a-z]{2,4})+$"
            , message = "Email not valid")
    private String email;
    private List<Phone> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User toUser() {
        User newUser = new User();
        this.phones.forEach(phone -> phone.setUser(newUser));
        BeanUtils.copyProperties(this, newUser);
        return newUser;
    }

    @Override
    public String toString() {
        return "CreateUserDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                '}';
    }
}
