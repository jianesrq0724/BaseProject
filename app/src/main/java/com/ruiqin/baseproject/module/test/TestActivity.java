package com.ruiqin.baseproject.module.test;

import android.os.Bundle;
import android.widget.Button;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;

import butterknife.OnClick;

public class TestActivity extends BaseActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }


    @OnClick(R.id.button)
    public void onViewClicked() {
        button.setText("");
    }
}
