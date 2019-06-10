package com.jonnyblog.wechat.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.jonnyblog.wechat.common.Constants;
import com.jonnyblog.wechat.model.entity.message.AccessToken;
import com.jonnyblog.wechat.service.MenuService;
import com.jonnyblog.wechat.service.WeChatService;
import com.jonnyblog.wechat.service.exception.ServiceException;
import com.jonnyblog.wechat.util.ToolUtil;

@Component
@Order(value = 1)
public class WeChatMenuRunner implements ApplicationRunner {
	private static Logger log = LoggerFactory.getLogger(WeChatMenuRunner.class);
	private static final String MENU_JSON_PATH = "config/menu.json";
	
	@Value("${wxbank.menu.refresh}") 
	private boolean needRefresh;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	WeChatService weChatService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(needRefresh){
			AccessToken token = weChatService.getAccessToken(Constants.APP_ID, Constants.APP_SECRET);
			if(token == null || StringUtils.isEmpty(token.getAccessToken())) {
				throw new ServiceException("创建菜单获取access_token失败");
			}
			int result=0;
            // 调用接口创建菜单
            result = menuService.createMenu(generateMenu(), token.getAccessToken());
            // 判断菜单创建结果
            if (0 == result) {
                log.info("菜单创建成功！");
            } else {
                log.info("菜单创建失败，错误码：" + result);
            }
		}
	}
	
	@SuppressWarnings("resource")
	private String generateMenu(){
		try{
			File file = new File("config/menu.json");
			if(!file.exists()) {
				log.error("文件[{}]不存在", MENU_JSON_PATH);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String tmp = null;
			StringBuffer resBuf = new StringBuffer(); 
		    while((tmp = br.readLine()) != null){
		    	resBuf.append(tmp);
		    }
		    String result = resBuf.toString();
		    log.info("菜单JSON：{}", result);
			return result;
		}catch (Exception e) {
            log.error(ToolUtil.getStackTrace(e));
        }
		return null;
	}

}
