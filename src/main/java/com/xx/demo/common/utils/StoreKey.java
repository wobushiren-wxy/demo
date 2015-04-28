package com.xx.demo.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.alonew.core.commons.info.HostInfo;
import com.alonew.core.commons.newstore.StoreManager;
import com.alonew.core.commons.newstore.StoreNotifyAble;

//存储在store里面的数据库表，缓存，使用flushall刷新缓存的时候会刷新这里全部的表
public enum StoreKey implements StoreNotifyAble {

	TEST, //
	Weather //天气代码
	;

	private String value;

	StoreKey(String key) {
		this.value = key;
	}

	StoreKey() {
		this.value = name();
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return this.value;
	}

	/**
	 * 获得枚举的名字
	 * 
	 * @return
	 */
	public String enumName() {
		return super.toString();
	}

	private static Map<String, StoreKey> map = new HashMap<String, StoreKey>();
	static {
		for (StoreKey storeKey : StoreKey.values()) {
			map.put(storeKey.toString(), storeKey);
		}
	}

	public static StoreKey valueOfEx(String key) {
		return map.get(key);
	}

	// 刷新缓存

	public void flushAll(Map<String, String> props) {
		if (props == null) {
			props = new HashMap<String, String>();
		}
		props.put("remoteIp", HostInfo.HostIp);
		props.put("remoteName", HostInfo.HostName);
		StoreManager.getInstance().notify(this.getValue(), props, StoreKey.class);
	}
	
	/**
	 * 通知其他服务器上的同一节点,除本机外
	 * @param props
	 */
	@Override
	public void flushRemote(Map<String, String> props) {
		if (props == null) {
			props = new HashMap<String, String>();
		}
		props.put("remoteIp", HostInfo.HostIp);
		props.put("remoteName", HostInfo.HostName);
		StoreManager.getInstance().notify(this.getValue(), props, StoreKey.class, false);
	}

	public static void main(String[] arg0) {
		System.out.println("@@@" + StoreKey.TEST);
	}

}