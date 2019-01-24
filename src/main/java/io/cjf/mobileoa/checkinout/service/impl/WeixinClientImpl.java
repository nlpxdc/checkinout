package io.cjf.mobileoa.checkinout.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.cjf.mobileoa.checkinout.api.WeixinApi;
import io.cjf.mobileoa.checkinout.service.WeixinClient;
import org.springframework.beans.factory.annotation.Value;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

public class WeixinClientImpl implements WeixinClient {

    private Retrofit retrofit;
    private WeixinApi weixinApi;

    @Value("${mp.appId}")
    private String appId;

    @Value("${mp.secret}")
    private String secret;

    public WeixinClientImpl(@Value("${weixin.baseUrl}") String url) throws MalformedURLException {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        weixinApi = retrofit.create(WeixinApi.class);
    }

    @Override
    public JSONObject getSnsAccessToken(String code) throws IOException {
        Call<JSONObject> call = weixinApi.getSnsAccessToken(appId, secret, code, "authorization_code");
        Response<JSONObject> response = call.execute();
        JSONObject jsonObject = response.body();
        return jsonObject;
    }

    @Override
    public JSONObject getSnsUserInfo(String access_token, String openid) throws IOException {
        Call<JSONObject> call = weixinApi.getSnsUserInfo(access_token, openid, "zh_CN");
        Response<JSONObject> response = call.execute();
        JSONObject jsonObject = response.body();
        return jsonObject;
    }
}
