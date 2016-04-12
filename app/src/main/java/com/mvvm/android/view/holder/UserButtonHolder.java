package com.mvvm.android.view.holder;

import com.mvvm.android.databinding.UserItemDataBindings;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/12 下午1:50
 */
public class UserButtonHolder extends RecyclerViewHolder<String> {
    private UserItemDataBindings mUserItemDataBinding;
    public UserButtonHolder(UserItemDataBindings itemBinding) {
        super(itemBinding.getRoot());
        mUserItemDataBinding = itemBinding;
    }

    public void onBind(String string) {
        mUserItemDataBinding.getUserItemModel().setUserName(string);
    }
}
