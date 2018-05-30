package com.carl.mvpdemo.pub.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * @author Carl
 * version 1.0
 * @since 2018/5/29
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;

    public CommonViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<View>();
        mItemView = itemView;
    }

    /**
     * 功能：设置textView的text
     * param：viewId:textView的id，text:设置的文本
     */
    public CommonViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 功能：设置textView的颜色
     */
    public CommonViewHolder setTextColor(int viewId, String text, int color) {
        TextView tv = getView(viewId);
        tv.setText(text);
        tv.setTextColor(color);
        return this;
    }


    public CommonViewHolder setTextClick(int viewId, String text, View.OnClickListener onClickListener) {
        TextView tv = getView(viewId);
        tv.setText(text);
        tv.setOnClickListener(onClickListener);
        return this;
    }


    private <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

}
