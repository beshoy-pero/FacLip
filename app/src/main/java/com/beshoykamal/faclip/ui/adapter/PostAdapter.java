package com.beshoykamal.faclip.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beshoykamal.faclip.R;
import com.beshoykamal.faclip.pojo.PostsModel;
import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private ArrayList<PostsModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutrecycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.bodyTV.setText(postsList.get(position).getBody());
        holder.userTV.setText(postsList.get(position).getUserId()+"");

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setPostsList(ArrayList<PostsModel>postsList){
        this.postsList=postsList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView userTV , titleTV , bodyTV;
        public PostViewHolder(View itemView){
            super(itemView);

            userTV=itemView.findViewById(R.id.userIDTv);
            titleTV=itemView.findViewById(R.id.titleTV);
            bodyTV=itemView.findViewById(R.id.bodyTV);
        }
    }
}
