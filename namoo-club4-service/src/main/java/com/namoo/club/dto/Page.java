package com.namoo.club.dto;

import java.util.List;

public class Page<T> {
	//
	private PageCondition pageCondition;
	private int total;
	
	private List<T> results;

	//--------------------------------------------------------------------------
	
	public boolean isNextPage() {
		//
		if (total - (pageCondition.getCurrentPage() * pageCondition.getCountPerPage()) > 0) {
			return true;
		}
		return false;
	}
	
	//--------------------------------------------------------------------------
	
	public int getCurrentPage() {
		return pageCondition.getCurrentPage();
	}

	public int getCountPerPage() {
		return pageCondition.getCountPerPage();
	}
	
	public PageCondition getPageCondition() {
		return pageCondition;
	}

	public void setPageCondition(PageCondition pageCondition) {
		this.pageCondition = pageCondition;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
