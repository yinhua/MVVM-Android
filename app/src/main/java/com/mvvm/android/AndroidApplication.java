package com.mvvm.android;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/6 下午6:35
 */
public class AndroidApplication extends Application {
    private static AndroidApplication instance;

    private Activity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AndroidApplication getContext() {
        return instance;
    }

    public static AndroidApplication getInstance() {
        return instance;
    }

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(@NonNull Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }

}
