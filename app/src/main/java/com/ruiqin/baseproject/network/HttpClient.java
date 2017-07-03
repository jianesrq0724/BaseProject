package com.ruiqin.baseproject.network;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class HttpClient {
    private HttpClient() {

    }

    public static HttpClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }
}
