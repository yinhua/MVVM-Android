package com.mvvm.android.viewmodel;

import android.view.View;

import com.mvvm.android.view.adapter.UserAdapter;
import com.mvvm.android.viewmodel.bind.BindListValue;
import com.mvvm.android.viewmodel.bind.BindTypeValue;
import com.mvvm.android.viewmodel.bind.BindValue;
import com.mvvm.android.viewmodel.iview.IUserListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午1:42
 */
public class UserListViewModel extends ViewModel {
    private IUserListView mIUserListView;
    private UserAdapter mUserAdapter = new UserAdapter();
    private List<BindTypeValue> mBindTypeValues = new ArrayList<>();

    public UserListViewModel(IUserListView iUserListView) {
        this.mIUserListView = iUserListView;
    }

    @BindView
    @SuppressWarnings("unused")
    public List<BindTypeValue> getUsers() {
        for (int i =0;i<10;i++) {
            int type = (i%2==0) ? mUserAdapter.TYPE_TEXT:mUserAdapter.TYPE_BUTTON;
            mBindTypeValues.add(new BindValue(type , "item" + i));
        }
        return mBindTypeValues;
    }

    @BindView
    @SuppressWarnings("unused")
    public BindListValue getUsers2() {
        BindListValue<String> bindListValue = new BindListValue();
        for (int i =0;i<10;i++) {
            bindListValue.add("item:" + 1);
        }
        return bindListValue;
    }

    @BindView
    @SuppressWarnings("unused")
    public UserAdapter getUserAdapter() {
        return mUserAdapter;
    }

    @BindView
    public View.OnClickListener getModifyUserListener() {
        return mOnClickModifyUserListener;
    }

    private View.OnClickListener mOnClickModifyUserListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mUserAdapter.updateFirstItem("yinhua");
            mUserAdapter.notifyDataSetChanged();
        }
    };
}
