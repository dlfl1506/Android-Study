package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private DrawerLayout drawer;
    private NavigationView nv;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        btn1 = findViewById(R.id.btn1);
        nv= findViewById(R.id.nv);

        btn1.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });

        nv.setNavigationItemSelectedListener(item ->{
            Log.d(TAG, "onCreate: item:"+item.getItemId());

            int id = item.getItemId();

            if(id == R.id.item1){
                Log.d(TAG, "onCreate: 메뉴1 클릭됨");
            }else if(id == R.id.item2){
                Log.d(TAG, "onCreate: 메뉴2 클릭됨");
            }else if(id == R.id.item3){
                Log.d(TAG, "onCreate: 메뉴3 클릭됨");
            }

            return true;
        });
    }
}