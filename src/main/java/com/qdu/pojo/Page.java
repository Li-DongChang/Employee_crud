package com.qdu.pojo;

import java.util.List;

/**
 * @author lidcha
 * @param <T>
 * @createDate ：2019年7月25日
 */
public class Page<T> {
	private int limit = 10;// 每页显示数量
	private int totalPages = 0;// 总页数
	private int totals = 0;// 总记录数
	private int page = 0;// 待显示页
	private List<T> list;// 页中的对象列表

	public Page(int totalPages, int totals, int page) {
		this.totalPages = totalPages;
		this.totals = totals;
		this.page = page;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Page [totalPages=" + totalPages + ", totals=" + totals + ", page=" + page + "]";
	}

}
