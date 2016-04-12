package com.mvvm.android.viewmodel;

import android.view.View;

import com.mvvm.android.viewmodel.iview.IUserView;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/8 下午5:58
 */
public class UserViewModel extends ViewModel {
    public final static int RADIO_INDEX_MALE = 0;
    public final static int RADIO_INDEX_FEMALE = 1;
    public final static int CHECKBOX_INDEX_ONE = 0;
    public final static int CHECKBOX_INDEX_TWO = 1;
    public final static int CHECKBOX_INDEX_THREE = 2;
    private IUserView mIUserView;
    private BindBoolean[] mBindRadioValue = new  BindBoolean[]{
            new BindBoolean(),
            new BindBoolean()
    };
    private BindBoolean[] mBindCheckboxValue = new  BindBoolean[]{
            new BindBoolean(),
            new BindBoolean(),
            new BindBoolean()
    };
    public UserViewModel(IUserView iUserView) {
       this.mIUserView = iUserView;
    }

    @BindView
    public View.OnClickListener getModifyUserListener() {
       return mOnClickModifyUser;
    }

    @BindView
    @SuppressWarnings("unused")
    public BindBoolean[] getBindRadioValue() {
        return mBindRadioValue;
    }

    @BindView
    @SuppressWarnings("unused")
    public BindBoolean[] getBindCheckboxValue() {
        return mBindCheckboxValue;
    }

    private View.OnClickListener mOnClickModifyUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mIUserView.showToast("mBindMale=" + mBindRadioValue[RADIO_INDEX_MALE].get()
                    + "  mBindFemale=" + mBindRadioValue[RADIO_INDEX_FEMALE].get() + "  1="
                    + mBindCheckboxValue[CHECKBOX_INDEX_ONE].get()+" 2="
                    + mBindCheckboxValue[CHECKBOX_INDEX_TWO].get() + " 3="
                    + mBindCheckboxValue[CHECKBOX_INDEX_THREE].get());
        }
    };
}
