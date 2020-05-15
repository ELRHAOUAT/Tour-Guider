package com.example.tourguider2.vue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.tourguider2.R;
import com.example.tourguider2.controleur.ControleLogin;

public class LoginActivity extends AppCompatActivity {
    private ControleLogin controleLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private SwitchCompat switchCompat;
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
        switchCompat = findViewById(R.id.remeberMe);



        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("switchCompat",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }else if(!switchCompat.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("switchCompat",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
     * ecouter la click sur login
     */
    private void ecouteLogin(){
        ((Button)findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v){
                String email=null;
                String password=null;
                //Récupération des données
                try {
                    email = editTextEmail.getText().toString();
                    password = editTextPassword.getText().toString();
                }catch (Exception e){}
                //Contrôle de données

                if(email == null || password == null|| email.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this,"Saisie incorrecte",Toast.LENGTH_SHORT).show();
                }
                else{
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
        this.controleLogin.creerTouristLogin(email,password,this);
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
            //((Button)findViewById(R.id.btnLogin)).performClick();
        }
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

}