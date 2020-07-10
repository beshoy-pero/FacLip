package com.beshoykamal.faclip.data;

import com.beshoykamal.faclip.pojo.PostsModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientPosts {

    private final static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private PostInterface postInterface;
    private static ClientPosts INSTANCE;

    public ClientPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //rxAdapter
                .build();

        postInterface = retrofit.create(PostInterface.class);
    }

    public static ClientPosts getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new ClientPosts();
        }
        return INSTANCE;
    }

    public Observable<List<PostsModel>> getPosts() {

        return postInterface.getPosts();
    }

}
