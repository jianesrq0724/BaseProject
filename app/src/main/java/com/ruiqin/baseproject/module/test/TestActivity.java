package com.ruiqin.baseproject.module.test;

import android.os.Bundle;
import android.widget.TextView;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;

public class TestActivity extends BaseActivity {
    TextView mTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTextView.setText("haha");
    }

    @Override
    protected int getFragmentId() {
        return 0;
    }
}
