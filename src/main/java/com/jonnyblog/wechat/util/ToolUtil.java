package com.jonnyblog.wechat.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class ToolUtil {

	/** 
	 * 首字母大写 
	 *  
	 * @param string 
	 * @return 
	 */  
	public static String toUpperCase4First(String string) {  
	    char[] methodName = string.toCharArray();  
	    methodName[0] = toUpperCase(methodName[0]);  
	    return String.valueOf(methodName);  
	}  
	  
	/** 
	 * 字符转成大写 
	 *  
	 * @param chars 
	 * @return 
	 */  
	public static char toUpperCase(char chars) {  
	    if (97 <= chars && chars <= 122) {  
	        chars ^= 32;  
	    }  
	    return chars;  
	}
	
	/**
	 * 通过变量名获取变量值
	 * 
	 * @param object
	 * @param name
	 * @return
	 */
	public static Object getClassValue(Object object, String name) {  
		try{
			Method m = (Method) object.getClass().getMethod(
				       "get" + toUpperCase4First(name));
			return m.invoke(object);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串空处理
	 * 
	 * @param str
	 * @return
	 */
	public static String toStringAndTrim(String str){
		if(str == null) return "";
		return str.trim();
	}
	/**
	 * 输出异常信息
	 * 
	 * @param e
	 * @return
	 */
	public static String getStackTrace(Exception e){
		StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw =  new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
	}
	
	/**
	 * 拼接路径字符串
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static String concatPath(String one, String two) {
		if(one.endsWith("/") && two.startsWith("/")) return one + two.replaceFirst("/", "");
		if(!one.endsWith("/") && !two.startsWith("/")) return one + "/" + two;
		return one + two;
	}
}
