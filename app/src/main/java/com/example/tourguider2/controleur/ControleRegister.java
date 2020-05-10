package com.example.tourguider2.controleur;


import android.content.Context;

import com.example.tourguider2.modele.ProfilRegister;
import com.example.tourguider2.outils.Serializer;

public final class ControleRegister {
    //propriétés
    private static ControleRegister instance = null;

    private static ProfilRegister profilRegister;

    private static String  nomFic = "saveProfileRegister";

    /**
     * Constructeur
     */
    private ControleRegister() {
        super();
    }

    public static final ControleRegister getInstance(Context contexte){
        if(ControleRegister.instance == null){
            ControleRegister.instance = new ControleRegister();
            recupSerialize(contexte);

        }
        return ControleRegister.instance;
    }

    /**
     *
     * @param userName
     * @param email
     * @param password
     * @param confirmPasswod
     * @param contexte
     */
    public void creerProfilRegister(String userName, String email, String password, String confirmPasswod, Context contexte){
        profilRegister = new ProfilRegister(userName,email,password,confirmPasswod);
        Serializer.serialize(nomFic,profilRegister,contexte);
    }

    /**
     *
     * @param contexte
     */
    private static void recupSerialize(Context contexte){
        profilRegister = (ProfilRegister)Serializer.deSerialize(nomFic,contexte);
    }

    /**
     *
     * @return
     */
    public String getNameUser(){
        if(profilRegister == null){
            return null;
        }
        else {
            return profilRegister.getUserName();
        }
    }
    /**
     *
     * @return
     */
    public String getEmail(){
        if(profilRegister == null){
            return null;
        }
        else {
            return profilRegister.getEmail();
        }
    }
    /**
     *
     * @return
     */
    public String getPassword(){
        if(profilRegister == null){
            return null;
        }
        else {
            return profilRegister.getPassword();
        }
    }
    /**
     *
     * @return
     */
    public String getConfirmPassword(){
        if(profilRegister == null){
            return null;
        }
        else {
            return profilRegister.getConfirmPassword();
        }
    }

}