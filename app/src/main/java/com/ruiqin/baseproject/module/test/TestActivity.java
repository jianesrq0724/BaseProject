package com.ruiqin.baseproject.module.test;

import android.app.AlertDialog;

import com.ruiqin.baseproject.R;
import com.ruiqin.baseproject.base.BaseActivity;
import com.ruiqin.baseproject.base.BasePresenter;
import com.ruiqin.baseproject.commonality.view.PermissionTipDialog;
import com.ruiqin.baseproject.commonality.view.ShareDialog;
import com.ruiqin.baseproject.commonality.view.TipCustomDialog;

import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }


    @OnClick(R.id.button)
    public void onViewClicked() {
        showShareDialog();
//        showPermissionDialog();
    }

    ShareDialog mShareDialog;

    private void showShareDialog() {
        if (mShareDialog == null) {
            mShareDialog = new ShareDialog(mContext, "http://www.baidu.com");
        }
        mShareDialog.show();

        AlertDialog mAlertDialog = new AlertDialog.Builder(mContext).show();
        mAlertDialog.show();
    }

    PermissionTipDialog mPermissionTipDialog;

    private void showPermissionDialog() {
        if (mPermissionTipDialog == null) {
            mPermissionTipDialog = new PermissionTipDialog(mContext);
        }
        mPermissionTipDialog.show();
    }

    private TipCustomDialog mTipCustomDialog;

    private void showTipDialog() {
        if (mTipCustomDialog == null) {
            mTipCustomDialog = new TipCustomDialog(mContext);
        }
        mTipCustomDialog.show();
    }

}
