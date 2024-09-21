package com.inicio.helder.commons.dto;

import java.util.List;

public class PaginationListResponse<T> {
    private PaginationListInfoResponse page;
    private List<T> items;

    public PaginationListResponse() {   }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PaginationListInfoResponse getPage() {
        return page;
    }

    public void setPage(PaginationListInfoResponse page) {
        this.page = page;
    }
}