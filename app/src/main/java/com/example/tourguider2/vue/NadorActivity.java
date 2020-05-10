package com.example.tourguider2.vue;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tourguider2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_nador);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        bottomNavigationView.setItemIconTintList(null);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_explore:
                            selectedFragment = new ExploreFragment();
                            break;
                        case R.id.nav_map:
                            selectedFragment = new MapFragment();
                            break;
                        case R.id.nav_wish_list:
                            selectedFragment = new WishListFragment();
                            break;
                        case R.id.nav_plans:
                            selectedFragment = new PlansFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };


}
