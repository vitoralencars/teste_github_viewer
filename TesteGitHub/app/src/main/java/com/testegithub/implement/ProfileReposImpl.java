package com.testegithub.implement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.testegithub.adapter.UserReposAdapter;
import com.testegithub.model.UserRepos;
import com.testegithub.presenter.ProfileReposPresenter;
import com.testegithub.util.StringKeys;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by vitoralencars on 06/09/17.
 */

public class ProfileReposImpl implements ProfileReposPresenter {

    @Override
    public void setProfileInfos(Context context, CircleImageView profileAvatar, TextView userName, Intent intent) {
        UserRepos userRepos = ((List<UserRepos>) intent.getSerializableExtra(StringKeys.USER_REPOS_INTENT)).get(0);
        Picasso.with(context)
                .load(userRepos.getOwner().getAvatarUrl())
                .resize(400,400)
                .into(profileAvatar);
        userName.setText(userRepos.getOwner().getLogin());
    }

    @Override
    public void listRepositories(Context context, RecyclerView recyclerView, Intent intent) {
        List<UserRepos> userRepositories = (List<UserRepos>) intent.getSerializableExtra(StringKeys.USER_REPOS_INTENT);
        UserReposAdapter adapter = new UserReposAdapter(context, userRepositories);
        recyclerView.setAdapter(adapter);
    }
}
