package com.example.tourguider2.modele;

import java.io.Serializable;

public class TouristLogin extends Person implements Serializable {
    private String email;
    private String password;

    public TouristLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
