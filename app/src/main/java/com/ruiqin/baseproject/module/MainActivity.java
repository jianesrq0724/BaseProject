package com.ruiqin.baseproject.module;

import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;
import com.ruiqin.baseproject.util.SPUtils;
import com.ruiqin.baseproject.util.ToastUtils;

public class MainActivity extends BaseActivity {


    @Override
    protected int getFragmentId() {
        return R.id.fragment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        addFragment(new BlankFragment());

        ToastUtils.showShort("haha");



//        SPUtils.getInstance("aaa").put("test", "test");
        boolean contains = SPUtils.getInstance("aaa").contains("test");

        String string = SPUtils.getInstance("aaa").getString("test");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
