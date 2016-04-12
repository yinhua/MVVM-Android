package com.mvvm.android.viewmodel.bind;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/7 下午6:47
 */
public class BindString extends BaseObservable implements Serializable {
    private String mValue;

    public BindString() {
    }

    public BindString(String value) {
        this.mValue =value;
    }

    public void set(String value) {
        if ((mValue == null) ? (value != null) : !mValue.equals(value)) {
            this.mValue = value;
            notifyChange();
        }
    }
    public boolean isEmpty() {
        return mValue == null || mValue.isEmpty();
    }

    public String get() {
        return mValue != null ? mValue : "";
    }
}
