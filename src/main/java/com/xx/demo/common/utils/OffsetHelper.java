package com.xx.demo.common.utils;

public class OffsetHelper {

	public static int getOffset(PageInfo pageInfo){
		int offset = (pageInfo.getPageIndex() - 1) * pageInfo.getPageSize();
		return offset > 0 ? offset : 0;
	}
}
