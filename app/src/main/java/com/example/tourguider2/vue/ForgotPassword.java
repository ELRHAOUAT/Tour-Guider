package com.example.tourguider2.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tourguider2.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ecouteRetourLogin();
        ecouteSend();
    }

    private void ecouteRetourLogin(){
        ((ImageButton)findViewById(R.id.btnRetourLogin)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ForgotPassword.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    private void ecouteSend(){
        ((Button)findViewById(R.id.btnSend)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ForgotPassword.this, ResetPasswordActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
