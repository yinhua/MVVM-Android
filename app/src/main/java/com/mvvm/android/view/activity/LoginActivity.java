package com.mvvm.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.android.R;
import com.mvvm.android.databinding.LoginDataBinding;
import com.mvvm.android.viewmodel.LoginViewModel;
import com.mvvm.android.viewmodel.iview.ILoginView;

public class LoginActivity extends BaseActivity
        implements ILoginView{

    private LoginDataBinding mLoginDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mLoginDataBinding.setLoginViewModel(new LoginViewModel(this));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
