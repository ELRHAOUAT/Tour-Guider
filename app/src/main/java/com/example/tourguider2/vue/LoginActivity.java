package com.example.tourguider2.vue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tourguider2.R;
import com.example.tourguider2.controleur.ControleLogin;
import com.example.tourguider2.outils.MesOutiles;

public class LoginActivity extends AppCompatActivity {
    private ControleLogin controleLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch remeberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    /**
     * initialisation des liens entre les composant graphique et les proprietes
     */
    private void init(){
        editTextEmail= (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        remeberMe = (Switch)findViewById(R.id.remeberMe);
        this.controleLogin = ControleLogin.getInstance(this);
        ecouteRetourChoose();
        ecouteLogin();
        recupProfil();
    }

    /**
     * ecouter le click sur le image button pour la retour à la page choose
     */
    private void ecouteRetourChoose(){
        ((ImageButton)findViewById(R.id.btnRetourLogin)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, ChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * ecouter de la click sur sing up
     * @param v
     */
    public void viewRegisterClicke(View v){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * ecouter la click sur forgot password
     * @param v
     */
    public void viewForgotPassword(View v){
        Intent intent= new Intent(LoginActivity.this,ForgotPassword.class);
        startActivity(intent);
    }

    /**
     * ecouter la click sur login
     */
    private void ecouteLogin(){
        ((Button)findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v){
                String email=null;
                String password=null;
                boolean checked=true;
                //Récupération des données
                try {
                    email = editTextEmail.getText().toString();
                    password = editTextPassword.getText().toString();
                    checked=remeberMe.getShowText();
                }catch (Exception e){}
                //Contrôle de données
                if(email == null || password == null|| email.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this,"Saisie incorrecte",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (checked){
                        MesOutiles.checked=true;
                    }
                    afficheResult(email,password);
                }
            }
        });
    }

    /**
     * fonction complet la fnction précédent d'ecouter la clik login
     * @param email
     * @param password
     */
    private void afficheResult(String email, String password){
        this.controleLogin.getTouristLogin(email,password,this);
        Toast.makeText(LoginActivity.this,"Saisie correcte",Toast.LENGTH_SHORT).show();
        Toast.makeText(LoginActivity.this,"Loading...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, CitysActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * récuperer les donnés déja enregistrer
     */
    public void recupProfil(){
        if(controleLogin.getEmailLogin() != null){
            editTextEmail.setText(controleLogin.getEmailLogin());
            editTextPassword.setText(controleLogin.getPasswordLogin());
        }
    }
}