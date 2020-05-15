package com.example.tourguider2.vue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tourguider2.R;
import com.google.android.material.navigation.NavigationView;

public class CitysActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;
    //Variables
    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citys);
        exploreNador();
        exploreSaidia();

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        naviagtionDrawer();
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
    private void exploreSaidia(){
        ((ImageButton)findViewById(R.id.imgBtnSaidia)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*
                888888888888888888888888888888888888==>Logout
                 */
                SharedPreferences preferences = getSharedPreferences("switchCompat",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","false");
                editor.apply();
                /*
                8888888888888888888888888888888888888
                 */
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
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

    private void naviagtionDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_account);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });



    }



    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }



}
