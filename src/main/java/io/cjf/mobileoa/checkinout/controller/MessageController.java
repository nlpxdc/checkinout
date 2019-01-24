package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/receive")
    public String receive(@RequestBody JSONObject jsonObject){
        logger.info("{}", jsonObject.toJSONString());
        return "";
    }
}
