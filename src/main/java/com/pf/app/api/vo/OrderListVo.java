package com.pf.app.api.vo;

public class OrderListVo implements VO {

    /**
     * 0:未付款,1代发货,2配送中,3已签收,4已关闭,5预售
     */
    private Integer status;

    private Integer pageNum;
    private Integer pageSize;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderListVo{");
        sb.append("status=").append(status);
        sb.append(", pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
