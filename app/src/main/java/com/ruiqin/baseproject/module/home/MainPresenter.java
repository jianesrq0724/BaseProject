package com.ruiqin.baseproject.module.home;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class MainPresenter extends MainContract.Presenter {

    @Override
    void testjudge(int value) {
        if (value > 0) {
            mView.testSuccess();
        } else {
            mView.textFail();
        }
    }
}
