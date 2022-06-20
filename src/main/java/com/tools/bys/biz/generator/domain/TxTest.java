package com.tools.bys.biz.generator.domain;

import java.io.Serializable;

/**
 * 
 * @TableName tx_test
 */
public class TxTest implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String column1;

    /**
     * 
     */
    private String column2;

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
    public String getColumn1() {
        return column1;
    }

    /**
     * 
     */
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    /**
     * 
     */
    public String getColumn2() {
        return column2;
    }

    /**
     * 
     */
    public void setColumn2(String column2) {
        this.column2 = column2;
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
        TxTest other = (TxTest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getColumn1() == null ? other.getColumn1() == null : this.getColumn1().equals(other.getColumn1()))
            && (this.getColumn2() == null ? other.getColumn2() == null : this.getColumn2().equals(other.getColumn2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getColumn1() == null) ? 0 : getColumn1().hashCode());
        result = prime * result + ((getColumn2() == null) ? 0 : getColumn2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", column1=").append(column1);
        sb.append(", column2=").append(column2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}