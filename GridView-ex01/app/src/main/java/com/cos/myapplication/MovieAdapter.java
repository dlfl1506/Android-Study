package com.cos.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


class MovieAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void addItem(Movie movie){
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }


    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       MainActivity mainActivityContext = (MainActivity)parent.getContext();

        LayoutInflater inflater = (LayoutInflater)mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.movie_item, parent, false);   // xml을 자바객체로 만든느 문법

        ImageView imgView = view.findViewById(R.id.img_view);
        TextView tvTitle = view.findViewById(R.id.tv_title);


        imgView.setImageResource(movies.get(position).getPic());
        tvTitle.setText(movies.get(position).getTitle());


        return view;
    }
}