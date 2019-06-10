package com.jonnyblog.wechat.util;

import java.util.Locale;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@Component
public class AppMessageUtil {

	private static Locale locale = LocaleContextHolder.getLocale();
	
	@Autowired
    private MessageSource messageSourceAutowired;
	
	private static MessageSource messageSource;
	
	@PostConstruct
    public void init() {
       this.messageSource = messageSourceAutowired;
    }
	
	public static String getMessage(String key){
		return messageSource.getMessage(key, null, locale);
	}
	
	public static String getMessage(String key, Object[] param){
		return messageSource.getMessage(key, param, locale);
	}
}
