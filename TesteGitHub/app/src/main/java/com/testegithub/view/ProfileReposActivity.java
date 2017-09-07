package com.testegithub.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.testegithub.R;
import com.testegithub.implement.ProfileReposImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileReposActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_transparent)
    Toolbar toolbar;
    @BindView(R.id.civProfileAvatar)
    CircleImageView civProfileAvatar;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.rvRepositories)
    RecyclerView rvRepositories;

    private ProfileReposImpl profileReposImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_repos);
        ButterKnife.bind(this);

        configureToolbar();

        profileReposImpl = new ProfileReposImpl();
        setProfileInfos();
        listUserRepositories();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void configureToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setProfileInfos(){
        profileReposImpl.setProfileInfos(this, civProfileAvatar, tvUserName, getIntent());
    }

    private void listUserRepositories(){
        profileReposImpl.listRepositories(this, rvRepositories, getIntent());
    }
}
