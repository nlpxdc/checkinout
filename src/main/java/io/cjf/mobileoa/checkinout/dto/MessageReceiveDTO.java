package io.cjf.mobileoa.checkinout.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
public class MessageReceiveDTO{

	@JacksonXmlProperty(localName = "Content")
	@JacksonXmlCData
	private String Content;

	@JacksonXmlProperty(localName = "CreateTime")
	private String CreateTime;

	@JacksonXmlProperty(localName = "ToUserName")
	@JacksonXmlCData
	private String ToUserName;

	@JacksonXmlProperty(localName = "FromUserName")
	@JacksonXmlCData
	private String FromUserName;

	@JacksonXmlProperty(localName = "MsgType")
	@JacksonXmlCData
	private String MsgType;

	@JacksonXmlProperty(localName = "MsgId")
	@JacksonXmlCData
	private String MsgId;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

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

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
