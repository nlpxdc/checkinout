package io.cjf.mobileoa.checkinout.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import io.cjf.mobileoa.checkinout.dto.MessageTextDTO;
import com.grum.geocalc.Coordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;
import io.cjf.mobileoa.checkinout.dto.MessageAutoResponseDTO;
import io.cjf.mobileoa.checkinout.dto.MessageReceiveDTO;
import io.cjf.mobileoa.checkinout.po.User;
import io.cjf.mobileoa.checkinout.service.WeixinClient;
import io.cjf.mobileoa.checkinout.service.impl.UserServiceImpl;
import io.cjf.mobileoa.checkinout.service.impl.WeixinClientImpl;
import javafx.beans.binding.ObjectBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeixinClientImpl weixinClient;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${weixin.accessToken}")
    private String accessToken;

    @Value("${checkInOut.latitude}")
    private Double checkLatitude;

    @Value("${checkInOut.longitude}")
    private Double checkLongitude;

//    @RequestMapping(value = "/receive", produces = MediaType.APPLICATION_XML_VALUE)
//    public MessageTextDTO receive(@RequestBody(required = false) String jsonObject, @RequestParam Map<String,String> allParams, @RequestParam(required = false) String echostr){
//        logger.info("{}", jsonObject);
//        logger.info("{}", allParams);
//        MessageTextDTO messageTextDTO = new MessageTextDTO();
//        messageTextDTO.setToUserName("oUwXe58JsPM6MBFsI3YvnbFIpg-8");
//        messageTextDTO.setFromUserName("gh_aad09ca98ab8");
//        messageTextDTO.setCreateTime(new Date().getTime());
//        messageTextDTO.setMsgType("text");
//        messageTextDTO.setContent("lalala");
//
//        String retStr = "<MessageTextDTO>\n" +
//                "    <Content>lalala</Content>\n" +
//                "    <ToUserName>oUwXe58JsPM6MBFsI3YvnbFIpg-8</ToUserName>\n" +
//                "    <FromUserName>gh_aad09ca98ab8</FromUserName>\n" +
//                "    <MsgType>text</MsgType>\n" +
//                "    <CreateTime>1548396765780</CreateTime>\n" +
//                "</MessageTextDTO>";
//
//
//        return messageTextDTO;
//        //return echostr;
//    }

    @PostMapping(value = "/receive2",produces = MediaType.APPLICATION_XML_VALUE)
    public Object receive2(@RequestBody JSONObject messageReceiveDTO) throws Exception {
        logger.info("{}",JSON.toJSONString(messageReceiveDTO));
//        MessageAutoResponseDTO messageAutoResponseDTO = new MessageAutoResponseDTO();
//        String fromUserName = messageReceiveDTO.getString("FromUserName");
//        messageAutoResponseDTO.setToUserName(fromUserName);
//        String toUserName = messageReceiveDTO.getString("ToUserName");
//        messageAutoResponseDTO.setFromUserName(toUserName);
//        messageAutoResponseDTO.setCreateTime(new Date().getTime());
//        messageAutoResponseDTO.setMsgType("text");
//
//        JSONObject userInfo = weixinClient.getUserInfo(accessToken, fromUserName);
//        String nickname = userInfo.getString("nickname");
//
//        messageAutoResponseDTO.setContent(String.format("welcome %s",nickname));
        String msgType = messageReceiveDTO.getString("MsgType");
        if (msgType.equals("event")){
            String event = messageReceiveDTO.getString("Event");
            if (event.equals("subscribe")){
                String fromUserName = messageReceiveDTO.getString("FromUserName");
                JSONObject userInfo = weixinClient.getUserInfo(accessToken, fromUserName);
                logger.info("{}",userInfo);
                String openid = userInfo.getString("openid");
                if (openid == null || openid.isEmpty()){
                    throw new Exception("openId is null, check access token");
                }
                User userOrigin = userService.getById(openid);
                if (userOrigin != null){
                    return "success";
                }
                User user = new User();
                user.setOpenid(openid);
                String nickname = userInfo.getString("nickname");
                Integer gender = userInfo.getInteger("sex");
                String avatarUrl = userInfo.getString("headimgurl");
                user.setNickname(nickname);
                user.setGender(gender);
                user.setAvatarUrl(avatarUrl);
                userService.create(user);

                MessageAutoResponseDTO messageAutoResponseDTO = new MessageAutoResponseDTO();
//                String fromUserName = messageReceiveDTO.getString("FromUserName");
                messageAutoResponseDTO.setToUserName(fromUserName);
                String toUserName = messageReceiveDTO.getString("ToUserName");
                messageAutoResponseDTO.setFromUserName(toUserName);
                messageAutoResponseDTO.setCreateTime(new Date().getTime());
                messageAutoResponseDTO.setMsgType("text");
                messageAutoResponseDTO.setContent(String.format("你好，%s，欢迎订阅",nickname));
                return messageAutoResponseDTO;
            }

            if (event.equals("CLICK")){
                String eventKey = messageReceiveDTO.getString("EventKey");

                if (eventKey == null){
                    return "success";
                }

                if (eventKey.equals("checkinout")){
                    String fromUserName = messageReceiveDTO.getString("FromUserName");
                    String positionUserKey = "position" + fromUserName;
                    Double latitude = (Double)redisTemplate.opsForHash().get(positionUserKey, "latitude");
                    Double longitude = (Double)redisTemplate.opsForHash().get(positionUserKey, "longitude");

                    Coordinate lat = Coordinate.fromDegrees(latitude);
                    Coordinate lng = Coordinate.fromDegrees(longitude);
                    Point userCurrentPosition = Point.at(lat, lng);

                    lat = Coordinate.fromDegrees(checkLatitude);
                    lng = Coordinate.fromDegrees(checkLongitude);
                    Point checkPosition = Point.at(lat, lng);

                    double distance = EarthCalc.harvesineDistance(userCurrentPosition, checkPosition); //in meters

                    if (distance > 100.00D){
                        MessageAutoResponseDTO messageAutoResponseDTO = new MessageAutoResponseDTO();
                        messageAutoResponseDTO.setToUserName(fromUserName);
                        String toUserName = messageReceiveDTO.getString("ToUserName");
                        messageAutoResponseDTO.setFromUserName(toUserName);
                        messageAutoResponseDTO.setCreateTime(new Date().getTime());
                        messageAutoResponseDTO.setMsgType("text");
                        messageAutoResponseDTO.setContent("不在打卡范围内");
                        return messageAutoResponseDTO;
                    }

                    userService.checkInOut(fromUserName,new Date());
                    MessageAutoResponseDTO messageAutoResponseDTO = new MessageAutoResponseDTO();
//                String fromUserName = messageReceiveDTO.getString("FromUserName");
                    messageAutoResponseDTO.setToUserName(fromUserName);
                    String toUserName = messageReceiveDTO.getString("ToUserName");
                    messageAutoResponseDTO.setFromUserName(toUserName);
                    messageAutoResponseDTO.setCreateTime(new Date().getTime());
                    messageAutoResponseDTO.setMsgType("text");
                    messageAutoResponseDTO.setContent("签到成功");
                    return messageAutoResponseDTO;
                }
            }

            if (event.equals("LOCATION")){
                String fromUserName = messageReceiveDTO.getString("FromUserName");
                Double latitude = messageReceiveDTO.getDouble("Latitude");
                Double longitude = messageReceiveDTO.getDouble("Longitude");
                JSONObject position = new JSONObject();
                position.put("latitude",latitude);
                position.put("longitude",longitude);
                String positionUserKey = "position" + fromUserName;
                redisTemplate.opsForHash().putAll(positionUserKey,position);
                redisTemplate.expire(positionUserKey,300, TimeUnit.SECONDS);
                return "success";
            }
        }


        return null;

    }

//    @GetMapping("/receive2")
//    public String receive2(@RequestParam Map<String,String> allParams){
//        logger.info("{}",allParams);
//        String echostr = allParams.get("echostr");
//        return echostr;
//
//    }
}
