package com.ruiqin.baseproject.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;
import com.ruiqin.baseproject.module.BlankFragment;
import com.ruiqin.baseproject.util.ToastUtils;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {

    @Override
    protected int getFragmentId() {
        return R.id.fragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new BlankFragment());
        mPresenter.testjudge(2);
    }

    @Override
    public void testSuccess() {
        ToastUtils.showShort("大于0");
    }

    @Override
    public void textFail() {
        ToastUtils.showShort("小于0");
    }

    @Override
    public boolean canBack() {
        mToolbarTitle.setText("test");
        return true;
    }
}
