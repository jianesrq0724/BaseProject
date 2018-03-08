package com.ruiqin.baselibrary.base;

import java.lang.ref.WeakReference;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public abstract class BasePresenter<T> {
    /**
     * View接口的弱引用
     */
    protected WeakReference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    public T getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            //解除关联
            mViewRef.clear();
            mViewRef = null;
        }
    }


}
