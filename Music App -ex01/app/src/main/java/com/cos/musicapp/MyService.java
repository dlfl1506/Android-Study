package com.cos.musicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate:  호출됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand:  호출됨");

        String musicName = intent.getStringExtra("musicName");

        if(musicName.equals("sample1")){
            mp = MediaPlayer.create(MyService.this,R.raw.sample1);
        }else if(musicName.equals("howl")){
            mp = MediaPlayer.create(MyService.this,R.raw.howl);
        }
        else{
            mp  = MediaPlayer.create(MyService.this,R.raw.sample2);
        }

        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy:  음악 종료됨.");
        mp.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

