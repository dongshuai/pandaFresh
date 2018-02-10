package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_banner")
public class PfBanner implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 图片url
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 跳转位置1:网页2：app
     */
    @Column(name = "app_id")
    private Byte appId;

    /**
     * 顺序
     */
    private Integer seq;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取图片url
     *
     * @return pic_url - 图片url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片url
     *
     * @param picUrl 图片url
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取跳转位置1:网页2：app
     *
     * @return app_id - 跳转位置1:网页2：app
     */
    public Byte getAppId() {
        return appId;
    }

    /**
     * 设置跳转位置1:网页2：app
     *
     * @param appId 跳转位置1:网页2：app
     */
    public void setAppId(Byte appId) {
        this.appId = appId;
    }

    /**
     * 获取顺序
     *
     * @return seq - 顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置顺序
     *
     * @param seq 顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PfBanner other = (PfBanner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getSeq() == null ? other.getSeq() == null : this.getSeq().equals(other.getSeq()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getSeq() == null) ? 0 : getSeq().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", appId=").append(appId);
        sb.append(", seq=").append(seq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}