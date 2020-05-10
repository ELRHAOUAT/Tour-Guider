package com.example.tourguider2.modele;

import java.io.Serializable;

public class ProfilRegister extends Person implements Serializable {
    //proprietés
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;

    /**
     * Constructeur
     * @param userName
     * @param email
     * @param password
     * @param confirmPassword
     */
    public ProfilRegister(String userName, String email, String password, String confirmPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
