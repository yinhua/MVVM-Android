package com.mvvm.android.viewmodel.bind;

import java.util.List;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午2:45
 */
public class BindListValue<T> extends BindTypeValue<T> {
    private List<T> mValueList;
    public BindListValue(int viewType, List<T> list) {
        super(viewType);
        mValueList = list;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public List<T> getList() {
        return mValueList;
    }
}
