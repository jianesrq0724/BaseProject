package com.ruiqin.baseproject.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;
import com.ruiqin.baseproject.module.BlankFragment;
import com.ruiqin.baseproject.module.home.adapter.MainRecyclerAdapter;
import com.ruiqin.baseproject.util.ToastUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new BlankFragment());
        mPresenter.setAdapter();
    }

    @Override
    public boolean canBack() {
        mToolbarTitle.setText("BaseProject");
        return false;
    }

    private long lastClickTime;

    @Override
    public void onBackPressed() {
        long currentClickTime = System.currentTimeMillis();
        if (currentClickTime - lastClickTime > 2000) {
            ToastUtils.showShort("再按一次退出");
            lastClickTime = currentClickTime;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setRecyclerAdapterSuccess(MainRecyclerAdapter mainRecyclerAdapter) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        mRecyclerView.setAdapter(mainRecyclerAdapter);
    }
}
