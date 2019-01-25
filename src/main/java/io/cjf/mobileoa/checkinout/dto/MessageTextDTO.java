package io.cjf.mobileoa.checkinout.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import retrofit2.http.Field;

import javax.xml.bind.annotation.XmlElement;

@JacksonXmlRootElement(localName = "xml")
public class MessageTextDTO {
    @JacksonXmlCData
    private String ToUserName;
    @JacksonXmlCData
    private String FromUserName;
    private Long CreateTime;
    @JacksonXmlCData
    private String MsgType;
    @JacksonXmlCData
    private String Content;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
