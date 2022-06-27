package com.tools.bys.biz.generator.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_sub
 */
@Data
@Builder
public class TSub implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer mainId;

    /**
     * 数字
     */
    private Integer column1;

    /**
     * 文本
     */
    private String column2;

    /**
     * 时间
     */
    private Date column3;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public Integer getMainId() {
        return mainId;
    }

    /**
     * 
     */
    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    /**
     * 数字
     */
    public Integer getColumn1() {
        return column1;
    }

    /**
     * 数字
     */
    public void setColumn1(Integer column1) {
        this.column1 = column1;
    }

    /**
     * 文本
     */
    public String getColumn2() {
        return column2;
    }

    /**
     * 文本
     */
    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    /**
     * 时间
     */
    public Date getColumn3() {
        return column3;
    }

    /**
     * 时间
     */
    public void setColumn3(Date column3) {
        this.column3 = column3;
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
        TSub other = (TSub) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMainId() == null ? other.getMainId() == null : this.getMainId().equals(other.getMainId()))
            && (this.getColumn1() == null ? other.getColumn1() == null : this.getColumn1().equals(other.getColumn1()))
            && (this.getColumn2() == null ? other.getColumn2() == null : this.getColumn2().equals(other.getColumn2()))
            && (this.getColumn3() == null ? other.getColumn3() == null : this.getColumn3().equals(other.getColumn3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMainId() == null) ? 0 : getMainId().hashCode());
        result = prime * result + ((getColumn1() == null) ? 0 : getColumn1().hashCode());
        result = prime * result + ((getColumn2() == null) ? 0 : getColumn2().hashCode());
        result = prime * result + ((getColumn3() == null) ? 0 : getColumn3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mainId=").append(mainId);
        sb.append(", column1=").append(column1);
        sb.append(", column2=").append(column2);
        sb.append(", column3=").append(column3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}