package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "test_mysql_enum")
public class TestMysqlEnum extends BaseEntity implements Serializable {


    @Column(name = "enums_type")
    private String enumsType;

    private static final long serialVersionUID = 1L;



    /**
     * @return enums_type
     */
    public String getEnumsType() {
        return enumsType;
    }

    /**
     * @param enumsType
     */
    public void setEnumsType(String enumsType) {
        this.enumsType = enumsType == null ? null : enumsType.trim();
    }


}