package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSONObject;
import io.cjf.mobileoa.checkinout.service.impl.WeixinClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WeixinClientImpl weixinClient;

    @PostMapping("/checkInOut")
    public void checkInOut(@RequestBody String code) throws IOException {
        JSONObject snsAccessToken = weixinClient.getSnsAccessToken(code);
        String access_token = snsAccessToken.getString("access_token");
        String openid = snsAccessToken.getString("openid");
    }
}
