package com.pf.app.api.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_hot_search")
public class PfHotSearch implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 搜索热词
     */
    private String word;

    /**
     * 搜索次数
     */
    private Integer times;

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
     * 获取搜索热词
     *
     * @return word - 搜索热词
     */
    public String getWord() {
        return word;
    }

    /**
     * 设置搜索热词
     *
     * @param word 搜索热词
     */
    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    /**
     * 获取搜索次数
     *
     * @return times - 搜索次数
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 设置搜索次数
     *
     * @param times 搜索次数
     */
    public void setTimes(Integer times) {
        this.times = times;
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
        PfHotSearch other = (PfHotSearch) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWord() == null ? other.getWord() == null : this.getWord().equals(other.getWord()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWord() == null) ? 0 : getWord().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", word=").append(word);
        sb.append(", times=").append(times);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}