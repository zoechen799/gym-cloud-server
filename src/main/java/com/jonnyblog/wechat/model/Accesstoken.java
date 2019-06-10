package com.jonnyblog.wechat.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accesstoken {

	@Id
	private String channle;
	private String granttype;
	private String appid;
	private String secret;
	private String accesstoken;
	private Timestamp createtime;
	private Integer expires;
	private String ext;
	
	public String getChannle() {
		return channle;
	}
	public void setChannle(String channle) {
		this.channle = channle;
	}
	public String getGranttype() {
		return granttype;
	}
	public void setGranttype(String granttype) {
		this.granttype = granttype;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getAccesstoken() {
		return accesstoken;
	}
	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getExpires() {
		return expires;
	}
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	
}
