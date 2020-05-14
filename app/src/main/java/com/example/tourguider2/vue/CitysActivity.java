package com.example.tourguider2.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tourguider2.R;
import com.google.android.material.navigation.NavigationView;

public class CitysActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citys);
        exploreNador();



    }

   private void exploreNador(){
        ((ImageButton)findViewById(R.id.imgBtnNador)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(CitysActivity.this, ExploreNadorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.nav_account:
                Toast.makeText(this, "You clicked account", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_plans:
                Toast.makeText(this, "You clicked plans", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_lang:
                Toast.makeText(this, "You clicked langage", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_wishlist:
                Toast.makeText(this, "You clicked wish list", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }




}
