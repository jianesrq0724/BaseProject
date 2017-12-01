package com.ruiqin.baseproject.network;

import com.ruiqin.baseproject.network.entity.RespLogin;

import io.reactivex.Flowable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public interface RestAPI {
    //登录
//    @POST("v1.0/a736014c6d44")
//    Flowable<RespLogin> login(@Body ReqLogin reqCheckMobileNo);

    @FormUrlEncoded
    @GET("preLogin")
    Flowable<RespLogin> login(String account, String userPw);

}
