package com.beshoykamal.faclip.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.beshoykamal.faclip.databinding.ActivityMainBinding;
import com.beshoykamal.faclip.pojo.PostsModel;
import com.beshoykamal.faclip.R;
import com.beshoykamal.faclip.ui.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);



        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();


        ////MVVM



        final PostAdapter adapter = new PostAdapter();
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);

      ///mvvm
        postViewModel.postmutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {

                adapter.setPostsList((ArrayList<PostsModel>) postsModels);
            }
        });

    }
}
