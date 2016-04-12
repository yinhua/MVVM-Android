package com.mvvm.android.viewmodel.bind;

import android.databinding.BaseObservable;

import java.util.List;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午2:45
 */
public abstract class BindTypeValue<T> extends BaseObservable {
    private int mViewType;

    public BindTypeValue(int viewType) {
       mViewType = viewType;
    }

    public int getViewType() {
        return mViewType;
    }

    public abstract T get();

    public abstract List<T> getList();
}

