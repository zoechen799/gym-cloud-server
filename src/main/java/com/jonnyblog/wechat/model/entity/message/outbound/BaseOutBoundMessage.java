package com.jonnyblog.wechat.model.entity.message.outbound;

/**
 * 发送消息基本属性
 * 
 */
public class BaseOutBoundMessage {

    // 接受方账号 OpenId
    private String ToUserName;

    // 开发者微信号
    private String FromUserName;

    // 消息创建时间
    private long CreateTime;

    // 消息类型
    private String MsgType;


    private int FuncFlag;


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

    public int getFuncFlag() {
        return FuncFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.FuncFlag = funcFlag;
    }

}
