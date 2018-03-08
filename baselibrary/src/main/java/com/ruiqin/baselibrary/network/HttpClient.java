package com.ruiqin.baselibrary.network;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.StringUtils;
import com.ruiqin.baselibrary.constant.NetWorkState;
import com.ruiqin.baselibrary.network.entity.HttpResult;
import com.ruiqin.baselibrary.util.ToastUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

import static com.ruiqin.baselibrary.constant.Constant.PLATFORM;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class HttpClient {

    public static HttpClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }

    public final RestAPI service;

    private HttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .retryOnConnectionFailure(false)//出现错误进行重新连接
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)//超过时间
                .addInterceptor(mInterceptor)//head拦截
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                // TODO: 2018/3/8
                .baseUrl("testt")
                .build();
        service = retrofit.create(RestAPI.class);
    }


    Interceptor mInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            //获取token值
            // TODO: 2018/3/8
//            String token = DataWareHouse.getToken();
            String token = "test";
            if (!StringUtils.isEmpty(token)) {
                builder.header("access-token", token);
            }
            builder.header("platform", PLATFORM);
            builder.header("version", AppUtils.getAppVersionName());
            Request request = builder.build();
            return chain.proceed(request);
        }
    };

    /**
     * 利用RxJava的map方法，统一对数据进行匹配
     *
     * @param <T>
     */
    public static class HttpResultFunc<T> implements Function<HttpResult<T>, T> {
        @Override
        public T apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
            if (tHttpResult.getStatus() != NetWorkState.SUCCEES) {
                networkMessage(tHttpResult.getMessage());
                throw new ApiException();
            }
            return tHttpResult.getResult();
        }
    }

    /**
     * 错误网络请求
     *
     * @param message
     */
    private static void networkMessage(String message) {
        Flowable.just(message).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String message) throws Exception {
                        ToastUtils.showShort(message);
                    }
                }, Throwable::printStackTrace);
    }

}
