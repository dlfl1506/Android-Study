package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUserList;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1,"asdsadsdafsdaasfdsfdasfda","sdafsdafsdafsdafaf",15));
        notes.add(new Note(2,"sadfsdafsdafdsafsdafsafsa","sdafsdafdsafsafsafdsafsdafffff",15));
        notes.add(new Note(3,"sadfsdafaytrokpygkwpetgkweggr","htrehrehtrehtreh",15));
        notes.add(new Note(4,"ehtyehetsfdsf","dssadsad",15));
        notes.add(new Note(5,"sdafasdfsaf","safdsfaasfa",15));
        notes.add(new Note(6,"sadfasdf","dfdasfasfsda",15));
        notes.add(new Note(7,"asdfas","asdfsdafdasfsaf",15));
        notes.add(new Note(8,"gsfdfsdgsfd","sfdgfdsgsdgfdgd",15));
        notes.add(new Note(9,"fdg","ffff",15));
        notes.add(new Note(10,"adsafdfadaf","gdgdgdgsd",15));
        notes.add(new Note(11,"hfghgfhfg","gfhgfdhfdh",15));
        notes.add(new Note(12,"gfdhfdghgfdhgfdh","sddfgreg",15));
        notes.add(new Note(13,"gfdhfdhfdgh","sdfsdfsdfsdf",15));
        notes.add(new Note(14,"fghgfdhgfdh","sfdsdfsdfsdfsdf",15));
        notes.add(new Note(15,"fdghfdghfdghgfdhdhgfdhfdgh","sdfdsfsfdsfdsd",15));
        notes.add(new Note(16,"fdghfgdhfdghfgdhdfghfgdhgfdhgfd","fsdfdfsdfsdf",15));
        notes.add(new Note(17,"hgfdhgfdhgfdhgfdhfd","",15));
        notes.add(new Note(18,"fdsgsfdgsdgsg","sdgsreregtrgrgr",15));
        notes.add(new Note(19,"sdfgsdfg","sfdgsfdgsfdg",15));
        notes.add(new Note(20,"sfdsdgsfdg","sdafagfdge",15));



        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvUserList = findViewById(R.id.rv_user_list);
        rvUserList.setLayoutManager(manager);

        noteAdapter = new NoteAdapter(notes);

        rvUserList.setAdapter(noteAdapter);

    }
}