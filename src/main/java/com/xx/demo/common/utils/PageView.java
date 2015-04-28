package com.xx.demo.common.utils;

public class PageView {

	private int count;
	private int curPage;
	private int num;
	private int nextPage;
	private int prePage;
	private int allPage;
	private int firstPage;
	private int lastPage;
	
	public PageView(int count, int num, int curPage){
		this.count = count;
		this.num = num;
		this.allPage = count / num  + 1;
		if(curPage < 1){
			this.curPage = 1;
		}else if(curPage > this.allPage){
			this.curPage = this.allPage;
		}else {
			this.curPage = curPage;
		}
		this.prePage = curPage - 1;
		if(this.prePage < 1){
			this.prePage = 1;
		}else if(prePage > this.allPage){
			this.prePage = this.allPage;
		}
		this.nextPage = curPage + 1;
		if(this.nextPage < 1){
			this.nextPage = 1;
		}else if(this.nextPage > this.allPage){
			this.nextPage = this.allPage;
		}
		this.firstPage = 1;
		this.lastPage = this.allPage;
	}
	
	public int getCount() {
		return count;
	}


	public int getCurPage() {
		return curPage;
	}


	public int getNum() {
		return num;
	}


	public int getNextPage() {
		return nextPage;
	}


	public int getPrePage() {
		return prePage;
	}


	public int getAllPage() {
		return allPage;
	}


	public int getFirstPage() {
		return firstPage;
	}


	public int getLastPage() {
		return lastPage;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
