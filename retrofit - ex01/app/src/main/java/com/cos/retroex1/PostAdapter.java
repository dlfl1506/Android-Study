package com.cos.retroex1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{

    private final List<Post> posts;
    public PostAdapter(List<Post> posts){
        this.posts =posts;
    }


    public void addItem(Post post){
        posts.add(post);
        notifyDataSetChanged();
    }
    public void removeItem(int position){
        posts.remove(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);   // main엑티비티에 연결할 객체를 생성해주는 인플레이터
        View view = inflater.inflate(R.layout.post_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUserId;
        private TextView tvId;
        private TextView tvTitle;
        private TextView tvText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tv_userId);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvText = itemView.findViewById(R.id.tv_text);

        }

        public void setItem(Post post) {
            tvUserId.setText(post.getUserId().toString());
            tvId.setText(post.getId().toString());
            tvTitle.setText(post.getTitle());
            tvText.setText(post.getText());

        }

    }

}
