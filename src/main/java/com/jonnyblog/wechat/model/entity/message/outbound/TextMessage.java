package com.jonnyblog.wechat.model.entity.message.outbound;

/**
 * 文本消息
 *
 */
public class TextMessage extends BaseOutBoundMessage{
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
