package com.ruiqin.baseproject.module.test;

import android.os.Bundle;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    protected int getFragmentId() {
        return 0;
    }
}
