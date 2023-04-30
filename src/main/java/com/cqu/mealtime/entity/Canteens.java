package com.cqu.mealtime.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Canteens)实体类
 *
 * @author makejava
 * @since 2023-04-26 22:32:41
 */
public class Canteens implements Serializable {
    @Serial
    private static final long serialVersionUID = 341848628506426476L;

    private Integer canteenId;

    private String canteenName;

    private String canteenHours;

    private Double canteenLongitude;

    private Double canteenLatitude;

    private String videoUrl;


    public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public String getCanteenHours() {
        return canteenHours;
    }

    public void setCanteenHours(String canteenHours) {
        this.canteenHours = canteenHours;
    }

    public Double getCanteenLongitude() {
        return canteenLongitude;
    }

    public void setCanteenLongitude(Double canteenLongitude) {
        this.canteenLongitude = canteenLongitude;
    }

    public Double getCanteenLatitude() {
        return canteenLatitude;
    }

    public void setCanteenLatitude(Double canteenLatitude) {
        this.canteenLatitude = canteenLatitude;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}

