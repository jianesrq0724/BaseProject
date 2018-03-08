package com.ruiqin.baseproject.module.login;

import android.widget.EditText;

import com.ruiqin.baselibrary.base.BaseActivity;
import com.ruiqin.baselibrary.base.BasePresenter;
import com.ruiqin.baseproject.R;
import com.ruiqin.baselibrary.interfaces.ILoading;
import com.ruiqin.baselibrary.network.HttpClient;
import com.ruiqin.baselibrary.network.entity.RespLogin;
import com.ruiqin.baselibrary.util.RxUtils;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_user_name_et)
    EditText mLoginUserNameEt;
    @BindView(R.id.login_user_pw_et)
    EditText mLoginUserPwEt;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        hideToolBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    /**
     * 登录
     */
    @OnClick(R.id.login_tv)
    public void onViewClicked() {
        HttpClient.getInstance().service.login(mLoginUserNameEt.getText().toString(), mLoginUserPwEt.getText().toString())
                .compose(RxUtils.getScheduler(true, (ILoading) mContext))
                .subscribe(new Consumer<RespLogin>() {
                    @Override
                    public void accept(RespLogin respLogin) throws Exception {

                    }
                }, Throwable::printStackTrace);
    }

}
