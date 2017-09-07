package com.testegithub.presenter;

import android.content.Context;
import android.widget.ProgressBar;

import com.testegithub.view.SearchActivity;

/**
 * Created by vitoralencars on 06/09/17.
 */

public interface SearchPresenter {

    void onSearchCall(SearchActivity activity, String username);

}
