package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd,btnMinus;
    private TextView tvNum;
    private Integer num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initSetting();
        initListener();

    }
    private void init(){
        btnAdd=findViewById(R.id.btn_add);
        btnMinus=findViewById(R.id.btn_minus);
        tvNum = findViewById(R.id.tv_num);
    }
    private void initSetting(){
        num=1;
        tvNum.setText(num.toString());
    }
    private void initListener(){
        btnAdd.setOnClickListener(v -> {
            num=num+1;
            tvNum.setText(num.toString());
        });

        btnMinus.setOnClickListener(v -> {
            num=num-1;
            tvNum.setText(num.toString());
        });

    }

}