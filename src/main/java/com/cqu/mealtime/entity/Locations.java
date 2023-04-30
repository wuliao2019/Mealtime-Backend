package com.cqu.mealtime.entity;

import java.io.Serializable;

/**
 * (Locations)实体类
 *
 * @author makejava
 * @since 2023-04-27 17:34:54
 */
public class Locations implements Serializable {
    private static final long serialVersionUID = 467361260936427294L;

    private Integer locationId;

    private String locationName;

    private Integer canId;


    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

}

