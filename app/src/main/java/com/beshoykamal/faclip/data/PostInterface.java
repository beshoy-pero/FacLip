package com.beshoykamal.faclip.data;

import com.beshoykamal.faclip.pojo.PostsModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Observable<List<PostsModel>> getPosts();

}

// law 3aiz post p id aw key han3mlha

//@GET("posts/{id}")
//public Call<PostsModel> getPosts(@Path("id") int postid);