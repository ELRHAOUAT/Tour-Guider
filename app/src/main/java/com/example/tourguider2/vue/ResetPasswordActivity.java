package com.example.tourguider2.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tourguider2.R;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        ecouteRetourLogin();
        ecouteDone();
    }

    private void ecouteRetourLogin(){
        ((ImageButton)findViewById(R.id.btnRetourLogin)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ResetPasswordActivity.this, ForgotPassword.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    private void ecouteDone(){
        ((Button)findViewById(R.id.btnDone)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ResetPasswordActivity.this, CitysActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
