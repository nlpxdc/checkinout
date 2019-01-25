package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/receive")
    public String receive(@RequestBody(required = false) String jsonObject, @RequestParam Map<String,String> allParams, @RequestParam String echostr){
        logger.info("{}", jsonObject);
        logger.info("{}", allParams);
        return echostr;
    }
}
