package com.testegithub.view;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.testegithub.R;
import com.testegithub.implement.SearchImpl;
import com.testegithub.util.Alerts;
import com.testegithub.util.ViewComponents;
import com.testegithub.view.view_interface.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements ViewComponents, SearchView{

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.etSearchProfile)
    EditText etSearchProfile;
    @OnClick(R.id.btnSearch)
    void search(){
        new SearchImpl().onSearchCall(this, etSearchProfile.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgressBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSearchConnectionError() {
        Alerts.displayConnectionErrorAlert(this);
    }

    @Override
    public void notFoundSearchResults() {
        Alerts.displayNotFoundAlert(this);
    }
}
