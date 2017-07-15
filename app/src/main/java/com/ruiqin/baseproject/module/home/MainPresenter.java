package com.ruiqin.baseproject.module.home;

import com.ruiqin.baseproject.module.home.adapter.MainRecyclerAdapter;
import com.ruiqin.baseproject.module.home.bean.MainRecyclerData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class MainPresenter extends MainContract.Presenter {
    private MainRecyclerAdapter mainRecyclerAdapter;
    private List<MainRecyclerData> mMainRecyclerDataList = new ArrayList<>();

    @Override
    void setAdapter() {
        initData();
        if (mainRecyclerAdapter == null) {
            mainRecyclerAdapter = new MainRecyclerAdapter(mMainRecyclerDataList);
            mView.setRecyclerAdapterSuccess(mainRecyclerAdapter);
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
