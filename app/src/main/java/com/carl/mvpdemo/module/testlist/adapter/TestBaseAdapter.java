package com.carl.mvpdemo.module.testlist.adapter;

import com.carl.mvpdemo.R;
import com.carl.mvpdemo.pub.base.CommonBaseAdapter;
import com.carl.mvpdemo.pub.base.CommonViewHolder;

import java.util.List;

/**
 * @author Carl
 * version 1.0
 * @since 2018/5/30
 */
public class TestBaseAdapter extends CommonBaseAdapter<String> {

    public TestBaseAdapter(List mDataList) {
        super(mDataList);
    }

    @Override
    public int getLayoutId() {
        return R.layout.pub_item_recyclerview;
    }

    @Override
    public void conner(CommonViewHolder holder, String entity) {
        holder.setText(R.id.content_tv, entity);
    }


}
