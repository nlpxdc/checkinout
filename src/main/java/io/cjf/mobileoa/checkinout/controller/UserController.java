package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSONObject;
import io.cjf.mobileoa.checkinout.enumeration.CheckType;
import io.cjf.mobileoa.checkinout.service.UserService;
import io.cjf.mobileoa.checkinout.service.impl.WeixinClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WeixinClientImpl weixinClient;

    @Autowired
    private UserService userService;

    @PostMapping("/checkInOut")
    public void checkInOut(@RequestBody String code) throws IOException {
        JSONObject snsAccessToken = weixinClient.getSnsAccessToken(code);
        String openid = snsAccessToken.getString("openid");

        userService.checkInOut(openid, CheckType.CheckIn, new Date());

    }
}
