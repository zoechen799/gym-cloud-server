package com.jonnyblog.wechat.controller;

import com.jonnyblog.wechat.service.CoreService;
import com.jonnyblog.wechat.service.WeChatService;
import com.jonnyblog.wechat.util.SignUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信核心验证控制器
 * Created by zihan.chen on 2017/6/14.
 */
@RestController
@RequestMapping(value = "/", produces = {"application/json;charset=utf-8"})
@Api(value = "/", description = "微信核心服务")
public class CoreController {
    private static Logger log = LoggerFactory.getLogger(CoreController.class);

    @Autowired
    private CoreService coreService;
    @Autowired
    private  WeChatService weChatService;
    
    //验证是否来自微信服务器的消息
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(notes = "", httpMethod = "GET", value = "微信公众平台token验证服务")
    public String checkSignature(@RequestParam(name = "signature" ,required = false) String signature  ,
                                 @RequestParam(name = "nonce",required = false) String  nonce ,
                                 @RequestParam(name = "timestamp",required = false) String  timestamp ,
                                 @RequestParam(name = "echostr",required = false) String  echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("微信公众平台接入成功");
            return echostr;
        }
        log.error("微信公众平台接入失败");
        return "";
    }
    
    @RequestMapping(value ="", method= RequestMethod.POST)
    public String onPost(HttpServletRequest req){
        String response = coreService.processRequest(req);
        log.debug(response);
        return response;
    }

}
