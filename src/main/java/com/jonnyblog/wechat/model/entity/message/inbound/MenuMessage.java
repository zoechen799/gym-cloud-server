package com.jonnyblog.wechat.model.entity.message.inbound;

/**
 * 点击菜单推送消息
 *
 */
public class MenuMessage extends BaseInboundMessage {
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey){
        this.EventKey = eventKey;
    }
}
