package com.mvvm.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.mvvm.android.R;
import com.mvvm.android.databinding.UserListDataBinding;
import com.mvvm.android.viewmodel.UserListViewModel;
import com.mvvm.android.viewmodel.iview.IUserListView;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午1:45
 */
public class UserListActivity extends BaseActivity
        implements IUserListView{
    private UserListDataBinding mUserListDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserListDataBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_user_list);
        mUserListDataBinding.setUserListViewModel(new UserListViewModel(this));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
