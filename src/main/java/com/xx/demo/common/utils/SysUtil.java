package com.xx.demo.common.utils;

public abstract class SysUtil {

	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * 获取运行环境操作系统类型,windows返回win,linux返回lin
	 */
	public static String getOs() {
		if (OS.startsWith("win")) {
			return "win";
		} else {
			return "lin";
		}
	}

	/**
	 * 获取系统配置<br>
	 * 如果有为key的配置则直接返回,否则根据操作系统添加_win或者_lin<br>
	 * 如果还没有则直接返回空
	 * 
	 */
//	public static String getConfValue(String key) {
//		Map<String, String> configs = ContextUtils.getBean("configs");
//		if (configs.containsKey(key)) {
//			return configs.get(key);
//		}
//		String os = getOs();
//		String osKey = key + "_" + os;
//		if (configs.containsKey(osKey)) {
//			return configs.get(osKey);
//		}
//		return "";
//	}
}
