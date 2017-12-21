package com.example.frosterskys.androidapp.restclient;

import com.loopj.android.http.*;

/**
 * Created by Frostersky's on 15.12.2017.
 */

public class RamblerNewsClient {

    private static final String BASE_URL = "http://192.168.0.3:1337";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
