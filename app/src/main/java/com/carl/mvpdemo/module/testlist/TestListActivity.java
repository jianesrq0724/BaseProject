package com.carl.mvpdemo.module.testlist;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.carl.mvpdemo.module.testlist.adapter.TestBaseAdapter;
import com.carl.mvpdemo.pub.base.BaseListActivity;
import com.carl.mvpdemo.pub.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Carl
 * version 1.0
 * @since 2018/5/30
 */
public class TestListActivity extends BaseListActivity {

    private List<String> mTitles = new ArrayList<>();


    public static void startActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), TestListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    private List<String> createData() {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            int i1 = random.nextInt(60);
            SystemClock.sleep(60);
            titles.add(String.valueOf((char) ('A' + i1)));
        }
        return titles;
    }

    @Override
    protected void initView() {
        super.initView();
        mToolbarManager.setToolbarTitle("下拉刷新");
        mBaseAdapter = new TestBaseAdapter(mTitles);
        initListView();
//        enableRefresh(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getFirstData();
    }

    @Override
    protected void getFirstData() {
        Disposable subscribe = Flowable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return createData();
            }
        }).compose(RxUtils.<List<String>>rxScheduler())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        mBaseAdapter.update(strings);
                        mBaseHandler.sendEmptyMessage(REFRESH_FIRST_LIST_VIEW);
                    }
                });
    }

    @Override
    protected void onLoad() {
        mBaseAdapter.addAll(createData());
    }
}
