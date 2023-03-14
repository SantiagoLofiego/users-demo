package com.tsoft.usersdemo.entities;

public class prueba {

    public static void main(String[] args){
        String email = "juan@rodriguezz.org";
       // email.matches("^[a-z]{3,}@[a-z]{3,}(\\.[a-z]{2,4})+$");
        System.out.println(email.matches("^[a-z]{3,}@[a-z]{3,}(\\.[a-z]{2,4})+$"));
    }
}
