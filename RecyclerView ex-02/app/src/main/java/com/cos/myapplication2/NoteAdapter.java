package com.cos.myapplication2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// 3번 상속받기
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private static final String TAG = "UserAdapter";


    // 4번 컬렉션생성
    private final List<Note> notes;

    public NoteAdapter(List<Note> notes){
        this.notes=notes;
    }

    // 5번 addItem,removeItem 함수 만들어주기
    public void addItem(Note note){
        notes.add(note);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        notes.remove(position);
    }


    // 7번 getView랑 똑같음.
    // 차이점이 있다면 ListView는 화면에 3개가 필요하면 최초 로딩시에 3개를 그려야하니까 getView가 3번 호출됨.
    // 그 다음에 스크롤을 해서 2개가 추가되야 될때 ,다시 getView를 호출함.
    // 하지만 recyclerView는 스크롤을 해서 2개가 추가되야 될때 onBindViewHolder를 호출함.
    // onCreateViewHolder는 해당 Activity 실행시에만 호출 됨.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater =(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);   // main엑티비티에 연결할 객체를 생성해주는 인플레이터
        View view = inflater.inflate(R.layout.note_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder:");
        holder.setItem(notes.get(position));
    }

    // 6번 컬렉션 크기 알려주기 (화면에 몇개 그려야될지를 알아야하기 때문)
    @Override
    public int getItemCount() {
        return notes.size();
    }

    // 1번 ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        // 2번 디자인 이 가지고 있는 위젯들을 선언
        private TextView tvTitle;
        private TextView tvSubTitle;
        private TextView tvMin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubTitle = itemView.findViewById(R.id.tv_subtitle);
            tvMin = itemView.findViewById(R.id.tv_min);
        }
        public void setItem(Note note){
            tvTitle.setText(note.getTitle());
            tvSubTitle.setText(note.getSubtitle());
            tvMin.setText(note.getMin().toString()+"m");
        }
    }
}
