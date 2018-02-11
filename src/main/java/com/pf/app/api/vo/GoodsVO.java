package com.pf.app.api.vo;

import javax.persistence.Column;
import javax.persistence.Id;

public class GoodsVO extends BaseVo implements VO{

    /**
     * 主键
     */
    private Long id;

    /**
     * 商品类型主键
     */
    private Long categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 城市名称
     */
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
