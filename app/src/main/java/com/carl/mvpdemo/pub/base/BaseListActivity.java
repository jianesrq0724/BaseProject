package com.carl.mvpdemo.pub.base;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.carl.mvpdemo.R;

/**
 * @author Carl
 * version 1.0
 * @since 2018/5/30
 */
public abstract class BaseListActivity<V, T extends BasePresenter<V>> extends BaseActivity<V, T> implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    protected CommonBaseAdapter mBaseAdapter;
    private int lastVisibleItem;
    private LinearLayoutManager mLinearLayoutManager;

    /**
     * 第一页数据刷新完毕
     */
    public static final int REFRESH_FIRST_LIST_VIEW = 0x10001;

    @Override
    protected void findView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRefreshLayout = findViewById(R.id.refresh_layout);
    }

    protected Handler mBaseHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case REFRESH_FIRST_LIST_VIEW:
                    if (mRefreshLayout != null) {
                        mRefreshLayout.setRefreshing(false);
                    }
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //设置下拉刷新监听
        mRefreshLayout.setOnRefreshListener(this);
        //RecyclerView滑动监听
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mBaseAdapter.getItemCount()) {
                    //先屏蔽上拉加载更多
//                    onLoad();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
            }
        });


    }


    /**
     * 初始化listView
     */
    protected void initListView() {
        if (mRecyclerView != null && mBaseAdapter != null) {
            mLinearLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            mRecyclerView.setAdapter(mBaseAdapter);
        }
    }

    /**
     * 禁止刷新
     *
     * @param flag
     */
    public void enableRefresh(boolean flag) {
        if (mRefreshLayout != null) {
            mRefreshLayout.setEnabled(flag);
        }
    }

    @Override
    public void setOnInteractListener() {

    }

    @Override
    public T createPresenter() {
        return null;
    }


    @Override
    public int getLayoutId() {
        return R.layout.pub_activity_refresh_list;
    }

    @Override
    public void onRefresh() {
        getFirstData();
    }

    /**
     * 获取ListView初始化数据
     */
    protected abstract void getFirstData();


    protected abstract void onLoad();


}
