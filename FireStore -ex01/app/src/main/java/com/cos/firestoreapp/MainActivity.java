package com.cos.firestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.cos.firestoreapp.model.BoardDetailDto;
import com.cos.firestoreapp.service.BoardService;
import com.cos.firestoreapp.service.MyCallback;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

        //dbSave();
        //dbReadAll();
        //dbSaveOrUpdate();
        //dbUpdate();

        //readTest();

        // 화면에 뿌릴예정
        //boardAll();


        BoardService boardService = new BoardService();

        boardService.boardDetail(new MyCallback<BoardDetailDto>() {
            @Override
            public void back(BoardDetailDto dto) {
                Log.d(TAG, "back: dto :" +dto);
            }
        });


    }





}