package com.mvvm.android.viewmodel.bind;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/7 下午6:47
 */
public class BindBoolean extends BaseObservable implements Serializable {
    private boolean mValue;
    public BindBoolean() {
    }

    public BindBoolean(boolean value) {
       this.mValue = value;
    }

    public void set(boolean value) {
        if (mValue != value) {
            this.mValue = value;
            notifyChange();
        }
    }

    public boolean get() {
        return mValue;
    }
}
