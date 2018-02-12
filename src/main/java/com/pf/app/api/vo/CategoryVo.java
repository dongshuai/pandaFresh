package com.pf.app.api.vo;

import javax.persistence.Id;

public class CategoryVo implements VO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 父菜单0：一级菜单
     */
    private Long pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", pid=" + pid +
                '}';
    }
}
