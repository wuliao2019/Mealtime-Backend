package com.cqu.mealtime.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Stalls)实体类
 *
 * @author makejava
 * @since 2023-04-27 17:20:14
 */
public class Stalls implements Serializable {
    @Serial
    private static final long serialVersionUID = 323219381708905055L;

    private Integer stallId;

    private String stallName;

    private Integer stallNum;

    private Integer canId;

    private Integer locId;

    private Integer tyId;

    private Double peopleCount;
    public Integer getStallId() {
        return stallId;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public Integer getStallNum() {
        return stallNum;
    }

    public void setStallNum(Integer stallNum) {
        this.stallNum = stallNum;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Integer getTyId() {
        return tyId;
    }

    public void setTyId(Integer tyId) {
        this.tyId = tyId;
    }

    public Double getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Double peopleCount) {
        this.peopleCount = peopleCount;
    }
}

