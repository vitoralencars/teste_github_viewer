package com.testegithub.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by vitoralencars on 06/09/17.
 */

public interface ProfileReposPresenter {

    void setProfileInfos(Context context, CircleImageView profileAvatar, TextView userName, Intent intent);

    void listRepositories(Context context, RecyclerView recyclerView, Intent intent);

}
