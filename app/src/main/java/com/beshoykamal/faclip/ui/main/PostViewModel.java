package com.beshoykamal.faclip.ui.main;

import android.util.Log;
import android.util.TimeUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.beshoykamal.faclip.data.ClientPosts;
import com.beshoykamal.faclip.pojo.PostsModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";


    MutableLiveData<List<PostsModel>> postmutableLiveData = new MutableLiveData<>();



    public void getPosts(){

       Observable<List<PostsModel>> observable = ClientPosts.getINSTANCE().getPosts()
               .subscribeOn(Schedulers.io())                        // UpStream
               .observeOn(AndroidSchedulers.mainThread());          // DownStream



//        observable.subscribe(o->postmutableLiveData.setValue(o),e-> Log.d(TAG, "getPosts: "+e));

        // we don't need use observable just use Single Because data income one not many > performance


        // Another Operate

       Observer<List<PostsModel>> observer =new Observer<List<PostsModel>>() {
           @Override
           public void onSubscribe(Disposable d) {
           }
           @Override
           public void onNext(List<PostsModel> value) {
               Log.d(TAG, "onNext: pero "+value);
               postmutableLiveData.setValue(value);
           }
           @Override
           public void onError(Throwable e) {
               Log.d(TAG, "onError: "+e);
           }
           @Override
           public void onComplete() {
           }
       };
       observable.subscribe(observer);

    }
}
