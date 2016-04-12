package com.mvvm.android.view.holder;

import com.mvvm.android.databinding.UserItemDataBinding;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午1:50
 */
public class UserHolder extends RecyclerViewHolder<String> {
    private UserItemDataBinding mUserItemDataBinding;
    public UserHolder(UserItemDataBinding itemBinding) {
        super(itemBinding.getRoot());
        mUserItemDataBinding = itemBinding;
    }

    public void onBind(String string) {
        mUserItemDataBinding.getUserItemModel().setUserName(string);
    }
}
