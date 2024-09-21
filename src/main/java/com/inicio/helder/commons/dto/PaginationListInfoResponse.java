package com.inicio.helder.commons.dto;


public class PaginationListInfoResponse {
    private int page;
    private int pageSize;
    private long total;
    private int totalPage;

    public PaginationListInfoResponse(int page, int pageSize, long total) {
        int _totalPage = (int) Math.round((double) total / pageSize);
        this.pageSize = pageSize;
        this.page = page;
        this.total = total;
        this.totalPage = _totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}