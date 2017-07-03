package com.ruiqin.baseproject.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        mBind = ButterKnife.bind(this);
        if (this instanceof BaseView) {
            mPresenter = InstanceUtil.getInstance(this, 0);
            mPresenter.setVM(this, InstanceUtil.getInstance(this, 1));
        }
        initView(savedInstanceState);
    }

    /**
     * add Fragment
     */
    protected void addFragment(BaseFragment fragment) {
        getFragmentManager().beginTransaction().replace(getFragmentId(), fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
    }

    protected abstract int getFragmentId();

    /**
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 获取子布局的Id
     *
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
