package com.cos.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


// 메인쓰레드 = UI 쓰레드 (그림을 그리는)
//            => 이벤트 리스너(os) [A버튼, B버튼]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";


    private TextView tvTitle;

    // 매니페스트에서 설정된 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 그림 그리는 함수 activity_main을 그린다. => 자바코드
        Log.d(TAG, "onCreate");
    }


}
