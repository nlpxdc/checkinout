package io.cjf.mobileoa.checkinout.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public interface WeixinClient {

    JSONObject getSnsAccessToken(String code) throws IOException;

    JSONObject getSnsUserInfo(String access_token, String openid) throws IOException;
}
