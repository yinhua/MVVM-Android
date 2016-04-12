package com.mvvm.android.viewmodel;

import android.view.View;

import com.mvvm.android.viewmodel.bind.BindString;
import com.mvvm.android.viewmodel.iview.ILoginView;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/7 下午2:43
 */

public class LoginViewModel extends ViewModel {
    private ILoginView mILoginView;
    public BindString mBindUserName = new BindString();
    private BindString mBindPassword = new BindString();
    public LoginViewModel(ILoginView iLoginView) {
        mILoginView = iLoginView;
    }

    public View.OnClickListener mOnClickLoginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mILoginView.showToast("登陆成功 UserName=" + mBindUserName.get()
                    + "   Password=" + mBindPassword.get());
        }
    };

    @SuppressWarnings("unused")
    public BindString getBindUserName() {
        return mBindUserName;
    }

    public void setBindUserName(String bindUserName) {
        mBindUserName.set(bindUserName);
    }

    @SuppressWarnings("unused")
    public BindString getBindPassword() {
        return mBindPassword;
    }

    public void setBindPassword(BindString bindPassword) {
        mBindPassword = bindPassword;
    }
}
