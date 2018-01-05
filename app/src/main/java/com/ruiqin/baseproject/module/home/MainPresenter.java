package com.ruiqin.baseproject.module.home;

import com.ruiqin.baseproject.base.BasePresenter;
import com.ruiqin.baseproject.module.home.adapter.MainRecyclerAdapter;
import com.ruiqin.baseproject.module.home.bean.MainRecyclerData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class MainPresenter extends BasePresenter<MainViewInterface> {
    private MainRecyclerAdapter mainRecyclerAdapter;
    private List<MainRecyclerData> mMainRecyclerDataList = new ArrayList<>();
    private MainModel mModel = new MainModel();

    void setAdapter() {
        initData();
        if (mainRecyclerAdapter == null) {
            mainRecyclerAdapter = new MainRecyclerAdapter(mMainRecyclerDataList);
            mViewRef.get().setRecyclerAdapterSuccess(mainRecyclerAdapter);
        } else {
            mainRecyclerAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 复制
     */
    private void initData() {
        List<MainRecyclerData> recyclerDataList = mModel.initData();
        if (recyclerDataList != null) {
            mMainRecyclerDataList.clear();
            mMainRecyclerDataList.addAll(recyclerDataList);
        }
    }
}
