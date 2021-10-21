package com.jun.bean;

import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-17 14:13
 */
public class Page <T>{
    public static final Integer PAGE_SIZE = 4;
    //当前页码
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer totalCount;
    //当前页数据显示
    private List<T> items;
    //分页条的请求地址：（分页条的抽取）
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        //数据边界的有效检查
        //如果当前页码小于1，则返回1
        if (pageNo < 1){
            return 1;
            //如果当前页码大于总页数，则返回总页数
        }else if (pageNo > getPageTotal()){
            return getPageTotal();
        }else {
            //如果当前页码大于等于1，小于等于总页数，则返回当前页码
            return pageNo;
        }
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
