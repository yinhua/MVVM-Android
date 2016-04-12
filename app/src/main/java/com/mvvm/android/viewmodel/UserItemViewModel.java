package com.mvvm.android.viewmodel;

import com.mvvm.android.viewmodel.bind.BindString;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午2:11
 */
public class UserItemViewModel extends ViewModel {
    private BindString mBindUserName = new BindString();

    public BindString getUserName() {
        return mBindUserName;
    }

    public void setUserName(String userName) {
        mBindUserName.set(userName);
    }
}
