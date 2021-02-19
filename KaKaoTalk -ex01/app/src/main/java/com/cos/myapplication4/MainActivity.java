package com.cos.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvChatList;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbarheader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbarheader = findViewById(R.id.toolbar_header);
        setSupportActionBar(toolbarheader);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new profileFragment()).commit(); // 최초화면

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.bottom_profile:
                    selectedFragment = new profileFragment();
                    break;
                case R.id.bottom_chat:
                    selectedFragment = new ChatFragment();
                    break;
                case R.id.bottom_shop:
                    selectedFragment = new ShopFragment();
                    break;
                case R.id.bottom_dot:
                    selectedFragment = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;

        });



    }
}