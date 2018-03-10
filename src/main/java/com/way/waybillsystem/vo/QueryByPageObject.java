package com.way.waybillsystem.vo;

public class QueryByPageObject {
	
	private int currentPage = 1;
	private int pageSize = 5;
	
	public int getStart(){
		return (currentPage - 1) * pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
