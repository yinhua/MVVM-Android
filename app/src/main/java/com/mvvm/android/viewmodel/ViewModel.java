package com.mvvm.android.viewmodel;

import android.databinding.BaseObservable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/6 下午6:28
 */

public class ViewModel extends BaseObservable {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @SuppressWarnings("unused")
    protected  @interface Command {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @SuppressWarnings("unsed")
    protected @interface BindView {
    }
}
