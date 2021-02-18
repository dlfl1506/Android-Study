package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private ImageView personView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personView = findViewById(R.id.iv_person);
        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        personView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,PersonActivity.class);
            startActivity(intent);
        });
    }
}