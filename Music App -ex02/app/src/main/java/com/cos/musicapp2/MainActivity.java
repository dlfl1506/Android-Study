package com.cos.musicapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import com.cos.musicapp2.MyService;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private TextInputEditText tiMusic;
    private Button btnStart, btnStop,btnpause;
    private MediaPlayer mp;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: 서비스 연결됨");
            mp = ((MyService.LocalBinder)service).gerMp();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.서비스 실행
        //서비스의 실행 = onCreate와 onBind이 실행된다. -> connection.onServiceConnected가 콜백됨
        Intent musicIntent = new Intent(MainActivity.this, MyService.class);
        bindService(musicIntent,connection,BIND_AUTO_CREATE);

        tiMusic = findViewById(R.id.ti_music);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnpause = findViewById(R.id.btn_pause);


        btnStart.setOnClickListener(v -> {
            //음악 재생
            mp.start();
        });

        btnStop.setOnClickListener(v -> {
            mp.pause();
            mp.seekTo(0);
        });

        btnpause.setOnClickListener(v -> {
            mp.pause();
        });
    }
}