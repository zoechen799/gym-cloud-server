package com.jonnyblog.wechat.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jonnyblog.wechat.common.Constants;
import com.jonnyblog.wechat.model.entity.message.outbound.Article;
import com.jonnyblog.wechat.model.entity.message.outbound.NewsMessage;
import com.jonnyblog.wechat.model.entity.message.outbound.TextMessage;
import com.jonnyblog.wechat.service.CoreService;
import com.jonnyblog.wechat.util.AppMessageUtil;
import com.jonnyblog.wechat.util.MessageUtil;
import com.jonnyblog.wechat.util.ToolUtil;

@Service("coreService")
public class CoreServiceImpl implements CoreService{
	private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);


    @Override
    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            log.debug(requestMap.toString());

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息信息
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            // 创建图文消息
            NewsMessage newsMessage = new NewsMessage();
            newsMessage.setToUserName(fromUserName);
            newsMessage.setFromUserName(toUserName);
            newsMessage.setCreateTime(new Date().getTime());
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
            newsMessage.setFuncFlag(0);
            List<Article> articleList = new ArrayList<Article>();
            
            // 自动回复文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	respMessage = getRespMessage(textMessage);
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            	respMessage = getRespMessage(textMessage);
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            	respMessage = getRespMessage(textMessage);
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            	respMessage = getRespMessage(textMessage);
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            	respMessage = getRespMessage(textMessage);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType =requestMap.get("Event");
                // 自定义菜单点击事件
                if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // click 类型
                }
                else if(eventType.equals(MessageUtil.EVENT_TYPE_VIEW)){
                    // view 类型
                }
                else if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
                    // subscribe(订阅)and 未关注群体扫描二维码
                    Article article1 = new Article();
                    article1.setTitle(AppMessageUtil.getMessage("base.subscribe.title"));
                    article1.setPicUrl(ToolUtil.concatPath(Constants.URL_WX, "/static/image/welcome.jpg"));
                    article1.setUrl(ToolUtil.concatPath(Constants.URL_WX, "/static/html/welcome.html"));

                    articleList.add(article1);

                    newsMessage.setArticleCount(articleList.size());
                    newsMessage.setArticles(articleList);
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);

                }
            }
        } catch (Exception e) {
        	log.error(ToolUtil.getStackTrace(e));
        }

        return respMessage;
    }

    /**
     * 判断是否是QQ表情
     *
     * @param content
     * @return
     */
    public static boolean isQqFace(String content) {
        boolean result = false;

        // 判断QQ表情的正则表达式
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
        Pattern p = Pattern.compile(qqfaceRegex);
        Matcher m = p.matcher(content);
        if (m.matches()) {
            result = true;
        }
        return result;
    }

    /**
     * 根据时间段判断自动回复内容
     * 
     * @return
     */
    private String getAutoReplyText() {
    	String message = AppMessageUtil.getMessage("replay.support.holiday.tips");
    	int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    	//公众号回复时间8:00-20:00
        if(hour >= 8 && hour < 20){
        	message = AppMessageUtil.getMessage("replay.support.wait.tips");
        }
        return message;
    }
    /**
     * 生成文本消息
     * 
     * @return
     */
    private String getRespMessage(TextMessage textMessage) {
    	String resp = AppMessageUtil.getMessage("base.service.error");
    	resp = getAutoReplyText();
    	textMessage.setContent(resp);
    	return MessageUtil.textMessageToXml(textMessage);
    }
}
