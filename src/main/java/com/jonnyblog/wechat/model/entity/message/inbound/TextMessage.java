package com.jonnyblog.wechat.model.entity.message.inbound;

/**
 * 文本消息
 *
 */
public class TextMessage extends BaseInboundMessage{
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
