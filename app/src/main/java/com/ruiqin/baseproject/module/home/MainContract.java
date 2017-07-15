package com.ruiqin.baseproject.module.home;

import com.ruiqin.baseproject.base.BaseModel;
import com.ruiqin.baseproject.base.BasePresenter;
import com.ruiqin.baseproject.base.BaseView;
import com.ruiqin.baseproject.module.home.adapter.MainRecyclerAdapter;
import com.ruiqin.baseproject.module.home.bean.MainRecyclerData;

import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public interface MainContract {
    interface Model extends BaseModel {
        List<MainRecyclerData> initData();
    }

    interface View extends BaseView {
        void setRecyclerAdapterSuccess(MainRecyclerAdapter mainRecyclerAdapter);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void setAdapter();
    }
}
