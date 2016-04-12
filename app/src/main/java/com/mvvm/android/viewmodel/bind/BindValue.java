package com.mvvm.android.viewmodel.bind;

import java.util.List;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午2:45
 */
public class BindValue<T> extends BindTypeValue<T> {
    private T mValue;

    public BindValue() {

    }

    public BindValue(int viewType, T value) {
        super(viewType);
        mValue = value;
    }

    public void set(T value) {
        if (mValue != value) {
            mValue =value;
            notifyChange();
        }
    }

    @Override
    public T get() {
        return mValue;
    }

    @Override
    public List<T> getList() {
        return null;
    }
}

