package com.mvvm.android.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.mvvm.android.R;
import com.mvvm.android.databinding.MainDataBinding;
import com.mvvm.android.viewmodel.MainViewModel;
import com.mvvm.android.viewmodel.iview.IHomeView;

public class MainActivity extends BaseActivity
        implements IHomeView {
    private MainDataBinding mMainDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainDataBinding = DataBindingUtil.setContentView(this
                , R.layout.activity_main);
        mMainDataBinding.setViewModel(new MainViewModel(this));
        startSplashActivity();
    }
    public void startSplashActivity() {
        startActivity(new Intent(this, SplashActivity.class));
    }

    @Override
    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void startUserActivity() {
        startActivity(new Intent(this, UserActivity.class));
    }

    @Override
    public void startUserListActivity() {
        startActivity(new Intent(this, UserListActivity.class));
    }
}
