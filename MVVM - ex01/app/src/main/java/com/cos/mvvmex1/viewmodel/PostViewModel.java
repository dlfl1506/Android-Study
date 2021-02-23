package com.cos.mvvmex1.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cos.mvvmex1.model.Post;


import java.util.ArrayList;
import java.util.List;



public class PostViewModel extends ViewModel {


    private static final String TAG = "PostViewModel";

    // LiveData, MutableLiveData
    private MutableLiveData<List<Post>> mtPosts = new MutableLiveData<>();

    public MutableLiveData<List<Post>> 구독(){
        return mtPosts;
    }

    public void 포스트한건추가(Post post){
        List<Post> posts = mtPosts.getValue();
        posts.add(post);
        mtPosts.setValue(posts);
    }

    public void 포스트변경(){
        List<Post> posts = mtPosts.getValue();
        posts.get(0).setTitle("테스트");
        mtPosts.setValue(posts);
        Log.d(TAG, "포스트변경: " + posts);
    }

    public void 데이터초기화(){
        List<Post> posts = new ArrayList<>();
        mtPosts.setValue(posts);
    }
}
