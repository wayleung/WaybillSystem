package com.way.waybillsystem.vo;

public class QueryByPageObject {
	
	private Integer currentPage = 1;
	private Integer pageSize = 5;
	
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
