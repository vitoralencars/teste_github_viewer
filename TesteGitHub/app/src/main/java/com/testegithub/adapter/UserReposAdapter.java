package com.testegithub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testegithub.R;
import com.testegithub.model.UserRepos;

import java.util.List;

/**
 * Created by vitoralencars on 06/09/17.
 */

public class UserReposAdapter extends RecyclerView.Adapter<UserReposAdapter.MyViewHolder>{

    private Context context;
    private List<UserRepos> userRepositories;
    private LayoutInflater layoutInflater;

    public UserReposAdapter(Context context, List<UserRepos> userRepositories){
        this.context = context;
        this.userRepositories = userRepositories;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_repos, parent, false);
        return new UserReposAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        UserRepos userRepos = userRepositories.get(position);

        holder.tvReposTitle.setText(userRepos.getReposName());
        holder.tvReposLanguage.setText(userRepos.getLanguage() != null ? userRepos.getLanguage() :
                context.getResources().getString(R.string.not_identified_language));
    }

    @Override
    public int getItemCount() {
        return userRepositories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvReposTitle, tvReposLanguage;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvReposTitle = (TextView)itemView.findViewById(R.id.tvReposTitle);
            tvReposLanguage = (TextView)itemView.findViewById(R.id.tvReposLanguage);
        }
    }

}
