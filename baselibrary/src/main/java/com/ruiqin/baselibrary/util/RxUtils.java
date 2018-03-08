package com.ruiqin.baselibrary.util;


import com.ruiqin.baselibrary.interfaces.ILoading;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 类描述:
 *
 * @author : ruiqin.shen
 * @date : 2017/12/8
 */
public class RxUtils {


    /**
     * 是否加载等待效果
     *
     * @param isLoading
     * @param loading
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> getScheduler(boolean isLoading, final ILoading loading) {
        FlowableTransformer<Object, Object> transformer = null;
        if (isLoading) {
            transformer = rxSchedulerLoading(loading);
        } else {
            transformer = rxScheduler();
        }
        return (FlowableTransformer<T, T>) transformer;
    }

    /**
     * 1.订阅在子线程、观察和取消订阅在UI线程.
     * 2.事件序列触发 显示loading 、结束（onError、onCompleted）取消Loading
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerLoading(final ILoading loading) {
        return new FlowableTransformer<T, T>() {

            @Override
            public Publisher<T> apply(Flowable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.newThread())
                        .doOnSubscribe(new Consumer<Subscription>() {
                            @Override
                            public void accept(Subscription subscription) throws Exception {
                                if (loading != null) {
                                    loading.showLoading();
                                }
                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .doOnTerminate(new Action() {
                            @Override
                            public void run() throws Exception {
                                if (loading != null) {
                                    loading.dismissLoading();
                                }
                            }
                        })
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

    }

    /**
     * 订阅在子线程、观察和取消订阅在UI线程.
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxScheduler() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.newThread())
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

    }
}
