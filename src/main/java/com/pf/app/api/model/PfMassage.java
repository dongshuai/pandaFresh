package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_massage")
public class PfMassage implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 消息类型1：系统消息2：个人消息
     */
    private Byte type;

    /**
     * 归属人
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 描述
     */
    private String content;

    /**
     * 发送时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片url
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 详细页面h5地址
     */
    @Column(name = "detail_h5_url")
    private String detailH5Url;

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
     * 获取消息类型1：系统消息2：个人消息
     *
     * @return type - 消息类型1：系统消息2：个人消息
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置消息类型1：系统消息2：个人消息
     *
     * @param type 消息类型1：系统消息2：个人消息
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取归属人
     *
     * @return user_id - 归属人
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置归属人
     *
     * @param userId 归属人
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取描述
     *
     * @return content - 描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置描述
     *
     * @param content 描述
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取发送时间
     *
     * @return create_time - 发送时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发送时间
     *
     * @param createTime 发送时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
     * 获取详细页面h5地址
     *
     * @return detail_h5_url - 详细页面h5地址
     */
    public String getDetailH5Url() {
        return detailH5Url;
    }

    /**
     * 设置详细页面h5地址
     *
     * @param detailH5Url 详细页面h5地址
     */
    public void setDetailH5Url(String detailH5Url) {
        this.detailH5Url = detailH5Url == null ? null : detailH5Url.trim();
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
        PfMassage other = (PfMassage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getDetailH5Url() == null ? other.getDetailH5Url() == null : this.getDetailH5Url().equals(other.getDetailH5Url()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getDetailH5Url() == null) ? 0 : getDetailH5Url().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", title=").append(title);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", detailH5Url=").append(detailH5Url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}