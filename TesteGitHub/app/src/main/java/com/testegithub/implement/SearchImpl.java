package com.testegithub.implement;

import android.content.Intent;
import com.testegithub.model.UserRepos;
import com.testegithub.presenter.SearchPresenter;
import com.testegithub.service.BaseUrl;
import com.testegithub.service.Builder;
import com.testegithub.service.Service;
import com.testegithub.util.StringKeys;
import com.testegithub.view.ProfileReposActivity;
import com.testegithub.view.SearchActivity;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vitoralencars on 06/09/17.
 */

public class SearchImpl implements SearchPresenter{

    @Override
    public void onSearchCall(final SearchActivity activity, String username) {
        activity.showProgressBar();
        Builder builder = new Builder(BaseUrl.USER_REPOS);
        Service service = builder.getService();
        service.getUserRepositories(username).enqueue(new Callback<List<UserRepos>>() {
            @Override
            public void onResponse(Call<List<UserRepos>> call, Response<List<UserRepos>> response) {
                activity.hideProgressBar();
                loadUserRepositories(activity, response.body());
            }

            @Override
            public void onFailure(Call<List<UserRepos>> call, Throwable t) {
                activity.hideProgressBar();
                activity.onSearchConnectionError();
            }
        });
    }

    private void loadUserRepositories(SearchActivity activity, List<UserRepos> userRepositories){
        Intent intent = new Intent(activity, ProfileReposActivity.class);
        if(userRepositories != null){
            intent.putExtra(StringKeys.USER_REPOS_INTENT, (Serializable) userRepositories);
            activity.startActivity(intent);
        }else{
            activity.notFoundSearchResults();
        }
    }
}
