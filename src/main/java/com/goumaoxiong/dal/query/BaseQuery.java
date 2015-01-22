package com.goumaoxiong.dal.query;

public class BaseQuery {

    private Integer pageSize;
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStart() {
        if (null == pageNum || null == pageSize) {
            return null;
        } else {
            return pageNum * pageSize;
        }
    }

    public Integer getSize() {
        return pageSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pageNum == null) ? 0 : pageNum.hashCode());
        result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BaseQuery other = (BaseQuery) obj;
        if (pageNum == null) {
            if (other.pageNum != null) return false;
        } else if (!pageNum.equals(other.pageNum)) return false;
        if (pageSize == null) {
            if (other.pageSize != null) return false;
        } else if (!pageSize.equals(other.pageSize)) return false;
        return true;
    }
}
