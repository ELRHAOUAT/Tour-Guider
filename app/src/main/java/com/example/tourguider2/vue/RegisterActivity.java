package com.example.tourguider2.vue;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tourguider2.R;
import com.example.tourguider2.controleur.ControleRegister;

public class RegisterActivity extends AppCompatActivity {
    //propriétés
    EditText txtUserName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfirmPassword;
    //Button btnRegister;
    private ControleRegister controleRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ecouteRetourChooseRegister();
        init();
    }


    /**
     * initialisation de lien avec des objets graphique
     */
    private void init(){
        txtUserName = (EditText)findViewById(R.id.txtUserName);
        txtEmail= (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText)findViewById(R.id.txtConfirmPasswod);
        //btnRegister = (Button) findViewById(R.id.btnRegister);
        this.controleRegister = ControleRegister.getInstance(this);
        ecouteRegister();
        recupProfil();
    }

    /**
     * Ecoute événement sur bouton Register
     */

    private void ecouteRegister(){
        ((Button)findViewById(R.id.btnRegister)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                String userName=null;
                String email=null;
                String password=null;
                String confirmPassword=null;
                //Récupération des données
                try {
                    userName = txtUserName.getText().toString();
                    email = txtEmail.getText().toString();
                    password = txtPassword.getText().toString();
                    confirmPassword = txtConfirmPassword.getText().toString();
                }catch (Exception e){}
                //Contrôle de données
                if(userName == null || email == null || password == null|| confirmPassword == null){
                    Toast.makeText(RegisterActivity.this,"Saisie incorrecte",Toast.LENGTH_SHORT).show();
                }
                else{
                    afficheResult(userName,email,password,confirmPassword);
                }
            }
        });
    }

    private void afficheResult(String userName,String email, String password, String confirmPassword){
        this.controleRegister.creerProfilRegister(userName,email,password,confirmPassword,this);
        Toast.makeText(RegisterActivity.this,"Welcome " + userName + " to Tour Guider",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegisterActivity.this, CitysActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void ecouteRetourChooseRegister(){
        ((ImageButton)findViewById(R.id.btnRetourRegister)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(RegisterActivity.this, ChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    public void viewLoginClicke(View v){//sign in
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void recupProfil(){
        if(controleRegister.getNameUser() != null){
            txtUserName.setText(controleRegister.getNameUser());
            txtEmail.setText(controleRegister.getEmail());
            txtPassword.setText(controleRegister.getPassword());
            txtConfirmPassword.setText(controleRegister.getConfirmPassword());
            //((Button)findViewById(R.id.btnRegister)).performClick();
        }
    }

}
