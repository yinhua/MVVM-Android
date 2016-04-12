package com.mvvm.android.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mvvm.android.R;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/11 下午2:02
 */
public class UserListActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
    }
}
