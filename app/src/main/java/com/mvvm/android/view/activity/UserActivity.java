package com.mvvm.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.android.R;
import com.mvvm.android.databinding.UserDataBinding;
import com.mvvm.android.viewmodel.UserViewModel;
import com.mvvm.android.viewmodel.iview.IUserView;

public class UserActivity extends BaseActivity
        implements IUserView{
    private UserDataBinding mUserDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        mUserDataBinding.setUserViewModel(new UserViewModel(this));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
