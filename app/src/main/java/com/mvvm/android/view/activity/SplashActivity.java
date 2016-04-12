package com.mvvm.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.mvvm.android.R;
import com.mvvm.android.databinding.SplashDataBinding;
import com.mvvm.android.viewmodel.SplashViewModel;
import com.mvvm.android.viewmodel.iview.ISplashView;

public class SplashActivity extends AppCompatActivity
        implements ISplashView{
    private SplashDataBinding mSplashDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        mSplashDataBinding.setSplashDataBinding(new SplashViewModel(this));
    }

    @Override
    public void startSplashAnimation() {
        //开始做闪屏动画,此处用handler代替,动画就不做了
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               //此处结束闪屏动画
           }
       }, 2000);
    }

    @Override
    public void finishSplash() {
        finish();
    }
}
