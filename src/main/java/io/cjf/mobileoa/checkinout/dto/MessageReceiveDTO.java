package io.cjf.mobileoa.checkinout.dto;

import javax.annotation.Generated;
import com.alibaba.fastjson.annotation.JSONField;

@Generated("com.robohorse.robopojogenerator")
public class MessageReceiveDTO{

	@JSONField(name="Content")
	private String content;

	@JSONField(name="CreateTime")
	private String createTime;

	@JSONField(name="ToUserName")
	private String toUserName;

	@JSONField(name="FromUserName")
	private String fromUserName;

	@JSONField(name="MsgType")
	private String msgType;

	@JSONField(name="MsgId")
	private String msgId;

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return createTime;
	}

	public void setToUserName(String toUserName){
		this.toUserName = toUserName;
	}

	public String getToUserName(){
		return toUserName;
	}

	public void setFromUserName(String fromUserName){
		this.fromUserName = fromUserName;
	}

	public String getFromUserName(){
		return fromUserName;
	}

	public void setMsgType(String msgType){
		this.msgType = msgType;
	}

	public String getMsgType(){
		return msgType;
	}

	public void setMsgId(String msgId){
		this.msgId = msgId;
	}

	public String getMsgId(){
		return msgId;
	}

	@Override
 	public String toString(){
		return 
			"MessageReceiveDTO{" + 
			"content = '" + content + '\'' + 
			",createTime = '" + createTime + '\'' + 
			",toUserName = '" + toUserName + '\'' + 
			",fromUserName = '" + fromUserName + '\'' + 
			",msgType = '" + msgType + '\'' + 
			",msgId = '" + msgId + '\'' + 
			"}";
		}
}