package com.jonnyblog.wechat.common.enums;

public enum DcDict {
	/** 1 收入 */
	D("1", "收入"),
	/** 0 支出 */
	C("0", "支出");
	
	String id;
	String value;
	
	private DcDict(String id, String value){
		this.id = id;
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
}
