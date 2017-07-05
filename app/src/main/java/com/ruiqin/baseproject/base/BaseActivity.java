package com.ruiqin.baseproject.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.util.InstanceUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Ruiqin on 2017/6/26.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {
    private Unbinder mBind;
    public Context mContext;
    public P mPresenter;
    private FrameLayout contentView;
    private Toolbar mToolbar;
    protected TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext = this;
        if (this instanceof BaseView) {
            mPresenter = InstanceUtil.getInstance(this, 0);
            mPresenter.setVM(this, InstanceUtil.getInstance(this, 1));
        }
        initToolBar();
    }

    /**
     * 是否可以返回
     *
     * @return
     */
    public boolean canBack() {
        return true;
    }

    /**
     * 初始化Toolbar
     */
    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && canBack()) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (canBack()) {
                    finish();
                }
                break;
        }
        return true;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (R.layout.activity_base == layoutResID) {
            super.setContentView(R.layout.activity_base);
            contentView = (FrameLayout) findViewById(R.id.layout_center);
            contentView.removeAllViews();
        } else if (layoutResID != R.layout.activity_base) {
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView);
            mBind = ButterKnife.bind(this);
        }
    }

    /**
     * add Fragment
     */
    protected void addFragment(BaseFragment fragment) {
//        getFragmentManager().beginTransaction().replace(getFragmentId(), fragment, fragment.getClass().getSimpleName()).commit();
        getSupportFragmentManager().beginTransaction().replace(getFragmentId(), fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
    }

    protected abstract int getFragmentId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }


}
