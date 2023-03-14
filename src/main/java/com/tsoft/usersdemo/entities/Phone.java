package com.tsoft.usersdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonIgnore
    private String id;
    private int number;
    private int cityCode;
    private int contrycode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getContrycode() {
        return contrycode;
    }

    public User getUser() {
        return user;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setContrycode(int contrycode) {
        this.contrycode = contrycode;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number=" + number +
                ", cityCode=" + cityCode +
                ", contrycode=" + contrycode +
                '}';
    }
}
