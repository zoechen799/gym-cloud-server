package com.jonnyblog.wechat.model.entity.message.inbound;

/**
 * 接收消息基本属性
 * 
 */

public class BaseInboundMessage {
    // 微信号
    private String ToUserName;

    // 用户OpenID
    private String FromUserName;

    // 消息创建时间
    private long CreateTime;

    // 消息类型
    private String MsgType;

    // 消息id
    private long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        this.ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        this.CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        this.MsgId = msgId;
    }
}
