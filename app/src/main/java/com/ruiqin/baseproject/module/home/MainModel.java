package com.ruiqin.baseproject.module.home;

import com.ruiqin.baseproject.module.demo.PickerViewDemoActivity;
import com.ruiqin.baseproject.module.home.bean.MainRecyclerData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class MainModel {

    public List<MainRecyclerData> initData() {
        List<MainRecyclerData> recyclerDataList = new ArrayList<>();
        recyclerDataList.add(new MainRecyclerData("PickerViewDemo", PickerViewDemoActivity.class));
        return recyclerDataList;
    }
}
