package com.mvvm.android.viewmodel.bind;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午2:45
 */
public class BindListValue<T> extends BindTypeValue<T> {
    private List<T> mValueList = new ArrayList<>();
    public BindListValue() {

    }
    public BindListValue(int viewType, List<T> list) {
        super(viewType);
        mValueList.addAll(list);
    }

    @Override
    public T get() {
        return null;
    }

    public void add(T value) {
        mValueList.add(value);
    }

    @Override
    public List<T> getList() {
        return mValueList;
    }

    public void set(T t) {

    }
}
