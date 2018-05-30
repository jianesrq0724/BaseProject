package com.carl.mvpdemo.module.home.adapter;

import com.carl.mvpdemo.R;
import com.carl.mvpdemo.pub.base.CommonBaseAdapter;
import com.carl.mvpdemo.pub.base.CommonViewHolder;

import java.util.List;

/**
 * @author Carl
 * version 1.0
 * @since 2018/5/29
 */
public class MainBaseAdapter extends CommonBaseAdapter<String> {

    public MainBaseAdapter(List<String> mDataList) {
        super(mDataList);
    }

    @Override
    public int getLayoutId() {
        return R.layout.pub_item_recyclerview;
    }

    @Override
    public void conner(final CommonViewHolder holder, final String entity) {
        holder.setText(R.id.content_tv, entity);
    }
}
