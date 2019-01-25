package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.cjf.mobileoa.checkinout.dto.MessageTextDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/receive", produces = MediaType.APPLICATION_XML_VALUE)
    public String receive(@RequestBody(required = false) String jsonObject, @RequestParam Map<String,String> allParams, @RequestParam(required = false) String echostr){
        logger.info("{}", jsonObject);
        logger.info("{}", allParams);
        MessageTextDTO messageTextDTO = new MessageTextDTO();
        messageTextDTO.setToUserName("oUwXe58JsPM6MBFsI3YvnbFIpg-8");
        messageTextDTO.setFromUserName("gh_aad09ca98ab8");
        messageTextDTO.setCreateTime(new Date().getTime());
        messageTextDTO.setMsgType("text");
        messageTextDTO.setContent("lalala");

        String retStr = "<xml>\n" +
                "    <Content>lalala</Content>\n" +
                "    <ToUserName>oUwXe58JsPM6MBFsI3YvnbFIpg-8</ToUserName>\n" +
                "    <FromUserName>gh_aad09ca98ab8</FromUserName>\n" +
                "    <MsgType>text</MsgType>\n" +
                "    <CreateTime>1548396765780</CreateTime>\n" +
                "</xml>";


        return retStr;
        //return echostr;
    }
}
