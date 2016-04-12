package com.mvvm.android.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvm.android.R;
import com.mvvm.android.databinding.UserItemDataBinding;
import com.mvvm.android.databinding.UserItemDataBindings;
import com.mvvm.android.view.holder.UserButtonHolder;
import com.mvvm.android.view.holder.UserHolder;
import com.mvvm.android.viewmodel.UserItemViewModel;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 上午11:45
 */
public class UserAdapter extends RecyclerAdapter {
    public static final int TYPE_TEXT=1;
    public static final int TYPE_BUTTON=2;

    @Override
    public RecyclerView.ViewHolder onCreateViewTypeHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (TYPE_BUTTON == viewType) {
            UserItemDataBinding userItemDataBinding = DataBindingUtil.inflate(inflater
                    , R.layout.item_user_info, parent, false);
            userItemDataBinding.setUserItemModel(new UserItemViewModel());
            return new UserHolder(userItemDataBinding);
        } else {
            UserItemDataBindings userItemDataBindings = DataBindingUtil.inflate(inflater
                    , R.layout.item_user_infos, parent, false);
            userItemDataBindings.setUserItemModel(new UserItemViewModel());
            return new UserButtonHolder(userItemDataBindings);
        }
    }

    public void updateFirstItem(String name) {
       updateData(0, name, TYPE_BUTTON);
    }
}
