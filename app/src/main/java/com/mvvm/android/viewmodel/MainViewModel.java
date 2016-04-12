package com.mvvm.android.viewmodel;

import android.view.View;

import com.mvvm.android.viewmodel.iview.IHomeView;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/6 下午6:28
 */
public class MainViewModel extends ViewModel {
    private IHomeView mIHomeView;

    public MainViewModel(IHomeView iHomeView) {
        this.mIHomeView = iHomeView;
    }

    @BindView
    public View.OnClickListener getOnClickUserListener() {
       return mOnClickUserListener;
    }

    @BindView
    public View.OnClickListener getOnClickLoginListener() {
       return mOnClickLoginListener;
    }

    @BindView
    public View.OnClickListener getOnClickUserListListener() {
        return mOnClickUserListListener;
    }

    private View.OnClickListener mOnClickUserListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mIHomeView.startUserActivity();
        }
    };

    private View.OnClickListener mOnClickLoginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mIHomeView.startLoginActivity();
        }
    };

    private View.OnClickListener mOnClickUserListListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mIHomeView.startUserListActivity();
        }
    };

    @SuppressWarnings("unused")
    public String getUrl() {
       return "http://www.test_url.com/pics/a.jpg";
    }
}
