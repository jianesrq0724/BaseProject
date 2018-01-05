package com.ruiqin.baseproject.module;

import android.os.Bundle;
import android.view.View;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseFragment;
import com.ruiqin.baseproject.base.BasePresenter;

public class BlankFragment extends BaseFragment {
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void stopLoad() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
