package org.page.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PaginationMeta {
	private Long totalCount;
	private int totalPage;
	private int pageSize;
	private int pageNumber;
	private boolean isLast;
	private boolean isFirst;
	
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	
	public static <T> PaginationMeta createPagination(Page<T> page) {
		PaginationMeta paginationMeta = new PaginationMeta();
		paginationMeta.setFirst(page.isFirst());
		paginationMeta.setLast(page.isLast());
		paginationMeta.setTotalCount(page.getTotalElements());
		paginationMeta.setPageNumber(page.getNumber());
		paginationMeta.setPageSize(page.getSize());
		paginationMeta.setTotalPage(page.getTotalPages());
		return paginationMeta;
	}

}
