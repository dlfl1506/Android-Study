package com.cos.myapplication4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private final List<Chat> chatList;

    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }

    // 5번 addItem,removeItem 함수 만들어주기
    public void addItem(Chat chat) {
        chatList.add(chat);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        chatList.remove(position);
    }

    @NonNull
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater =(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);   // main엑티비티에 연결할 객체를 생성해주는 인플레이터
        View view = inflater.inflate(R.layout.chat_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MyViewHolder holder, int position) {
        holder.setItem(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_img;
        private TextView tvUsername;
        private TextView tvtime;
        private TextView tvcontent;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.profile_img);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvtime= itemView.findViewById(R.id.tv_time);
            tvcontent=itemView.findViewById(R.id.tv_content);
        }

        public void setItem(Chat chat){
            iv_img.setImageResource(chat.getPic());
            tvUsername.setText(chat.getUsername());
            tvtime.setText(chat.getTime());
            tvcontent.setText(chat.getContent());
        }
    }

}
