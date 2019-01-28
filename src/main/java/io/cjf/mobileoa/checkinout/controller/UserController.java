package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.cjf.mobileoa.checkinout.dto.CheckInOutDTO;
import io.cjf.mobileoa.checkinout.po.User;
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
    public void checkInOut(@RequestBody CheckInOutDTO checkInOutDTO) throws IOException {

        JSONObject snsAccessToken = weixinClient.getSnsAccessToken(checkInOutDTO.getCode());
        String openid = snsAccessToken.getString("openid");

        userService.checkInOut(openid , new Date());

    }

    @GetMapping("/getWithPage")
    public PageInfo<User> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        PageInfo<User> userPageInfo = userService.getWithPage(pageNum);
        return userPageInfo;
    }
}
