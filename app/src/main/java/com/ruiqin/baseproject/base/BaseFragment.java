package com.ruiqin.baseproject.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ruiqin.baseproject.util.InstanceUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
    private Unbinder mBind;
    public P mPresenter;
    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mBind = ButterKnife.bind(this, view);
        if (this instanceof BaseView) {
            mPresenter = InstanceUtil.getInstance(this, 0);
            mPresenter.setVM(this, InstanceUtil.getInstance(this, 1));
        }
        initView(view, savedInstanceState);
        return view;
    }

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }
}
