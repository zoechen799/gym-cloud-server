package com.jonnyblog.wechat.service;

import net.sf.json.JSONObject;

/**
 * 菜单服务类
 *
 */
public interface MenuService {
	
	/**
	 * 获取菜单
	 * @param accessToken
	 * @return
	 */
	public JSONObject getMenu(String accessToken);
	/**
	 * 创建菜单
	 * @param menu
	 * @param accessToken
	 * @return
	 */
    public int createMenu(String menu, String accessToken);
    /**
     * 删除菜单
     * @param accessToken
     * @return
     */
    public int deleteMenu(String accessToken);
	
}
