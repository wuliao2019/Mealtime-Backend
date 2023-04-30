package com.cqu.mealtime.entity;

import java.io.Serializable;

/**
 * (Types)实体类
 *
 * @author makejava
 * @since 2023-04-27 17:34:36
 */
public class Types implements Serializable {
    private static final long serialVersionUID = -22776837614339595L;

    private Integer typeId;

    private String typeName;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}

