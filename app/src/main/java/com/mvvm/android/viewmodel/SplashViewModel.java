package com.mvvm.android.viewmodel;

import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;

import com.mvvm.android.AndroidApplication;
import com.mvvm.android.BR;
import com.mvvm.android.R;
import com.mvvm.android.viewmodel.iview.ISplashView;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/8 下午5:14
 */
public class SplashViewModel extends ViewModel {
    private ISplashView mISplashView;
    private Drawable mDrawable;

    public SplashViewModel(ISplashView iSplashView) {
       this.mISplashView = iSplashView;
        startSplash();
    }

    public void startSplash() {
       requestSplashImage();
       mISplashView.startSplashAnimation();
    }

    private void requestSplashImage() {
        //此处做请求服务器的闪屏图片
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mDrawable = ContextCompat.getDrawable(AndroidApplication.getContext()
                        , R.drawable.splash_image);
                notifyPropertyChanged(BR.splashDrawable);
                mISplashView.finishSplash();
            }
        }, 2000);
    }

    @SuppressWarnings("unused")
    public String getSplashUrl() {
       return "www.baidu.com";
    }

    @Bindable
    public Drawable getSplashDrawable() {
        return mDrawable;
    }
}
