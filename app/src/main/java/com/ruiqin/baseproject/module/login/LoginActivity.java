package com.ruiqin.baseproject.module.login;

import android.widget.EditText;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;
import com.ruiqin.baseproject.network.HttpClient;
import com.ruiqin.baseproject.network.entity.RespLogin;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
    protected int getFragmentContentId() {
        return 0;
    }

    @OnClick(R.id.login_tv)
    public void onViewClicked() {
        HttpClient.getInstance().service.login(mLoginUserNameEt.getText().toString(), mLoginUserPwEt.getText().toString())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RespLogin>() {
                    @Override
                    public void accept(RespLogin respLogin) throws Exception {

                    }
                });
    }
}
