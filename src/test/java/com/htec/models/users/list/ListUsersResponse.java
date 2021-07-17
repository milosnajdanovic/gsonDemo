package com.htec.models.users.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.htec.models.users.common.Data;
import com.htec.models.users.common.Support;

public class ListUsersResponse implements Serializable
{

    @SerializedName("page")
    private Integer page;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("total")
    private Integer total;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("data")
    private List<Data> data = new ArrayList<>();
    @SerializedName("support")
    private Support support;
    private final static long serialVersionUID = 2575528836223329033L;

    public ListUsersResponse() {
    }

    public ListUsersResponse(Integer page, Integer perPage, Integer total, Integer totalPages, List<Data> data, Support support) {
        super();
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.support = support;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

}
