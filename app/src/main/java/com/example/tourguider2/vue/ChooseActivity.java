package com.example.tourguider2.vue;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tourguider2.R;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ecouteLogin();
        ecouteRegister();
        SharedPreferences preferences = getSharedPreferences("switchCompat",MODE_PRIVATE);
        String checked = preferences.getString("remember","");
        if(checked.equals("true")){
            Intent intent = new Intent(ChooseActivity.this, CitysActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else if(!checked.equals("false")){
            Toast.makeText(ChooseActivity.this, "Please Sing In.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Ecouter de la click sur le button login
     */
    private void ecouteLogin(){
        ((Button)findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChooseActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * Ecouter de la click sur le button register
     */
    private void ecouteRegister(){
        ((Button)findViewById(R.id.btnRegister)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChooseActivity.this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * Ecouter de la click sur le button la fliche pour quitter l'app
     */
    public void clickExit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    /**
     * Ecouter de la click sur le button skip pour passer sans login ou register
     */
    public void clickSkip(View v){
        Intent intent = new Intent(ChooseActivity.this, CitysActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

