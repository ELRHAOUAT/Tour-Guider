package com.example.tourguider2.controleur;

import android.content.Context;

import com.example.tourguider2.modele.TouristLogin;
import com.example.tourguider2.outils.Serializer;

public class ControleLogin {
    private static String nomFicLogin = "saveLogin";
    private static TouristLogin touristLogin;
    private static ControleLogin instance = null;

    /**
     *
     */
    private ControleLogin() {
        super();
    }
    public static final ControleLogin getInstance(Context contexte){
        if(ControleLogin.instance == null){
            ControleLogin.instance = new ControleLogin();
            recupSerialize(contexte);
        }
        return ControleLogin.instance;
    }
    /**
     *
     * @param email
     * @param password
     * @param contexte
     */
    public void creerTouristLogin(String email, String password, Context contexte){
        touristLogin = new TouristLogin(email,password);
        Serializer.serialize(nomFicLogin,touristLogin,contexte);
    }

    /**
     *
     * @return
     */
    public String getEmailLogin(){
        if(touristLogin == null){
            return null;
        }
        else {
            return touristLogin.getEmail();
        }
    }

    /**
     *
     * @return
     */
    public String getPasswordLogin(){
        if(touristLogin == null){
            return null;
        }
        else {
            return touristLogin.getPassword();
        }
    }
    private static void recupSerialize(Context contexte){
        touristLogin = (TouristLogin) Serializer.deSerialize(nomFicLogin,contexte);
    }
}
