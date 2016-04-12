package com.mvvm.android.viewmodel;

import com.mvvm.android.view.adapter.UserAdapter;
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

    public UserListViewModel(IUserListView iUserListView) {
        this.mIUserListView = iUserListView;
    }

    @BindView
    @SuppressWarnings("unused")
   public List<BindTypeValue> getUsers() {
        List<BindTypeValue> bindTypeValueList = new ArrayList<>();
        for (int i =0;i<10;i++) {
            int type = (i%2==0) ? mUserAdapter.TYPE_TEXT:mUserAdapter.TYPE_BUTTON;
            bindTypeValueList.add(new BindValue(type , "item" + i));
        }
        return bindTypeValueList;
    }

    @BindView
    @SuppressWarnings("unused")
    public UserAdapter getUserAdapter() {
        return mUserAdapter;
    }
}
