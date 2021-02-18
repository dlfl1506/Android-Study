package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;

public class PersonActivity extends AppCompatActivity {


    private ImageView icback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        icback = findViewById(R.id.iv_back);
        icback.setOnClickListener(v -> {
            finish();
        });

    }
}