package io.cjf.mobileoa.checkinout.api;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeixinApi {

    @GET("sns/oauth2/access_token")
    Call<JSONObject> getSnsAccessToken(@Query("appid") String appid, @Query("secret") String secret, @Query("code") String code, @Query("grant_type") String grant_type);

    @GET("sns/userinfo")
    Call<JSONObject> getSnsUserInfo(@Query("access_token") String access_token, @Query("openid") String openid, @Query("lang") String lang);

}
