package com.cqu.mealtime.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Pictures)实体类
 *
 * @author makejava
 * @since 2023-05-16 22:57:39
 */
public class Pictures implements Serializable {
    @Serial
    private static final long serialVersionUID = -55160373799063420L;

    private Integer pictureId;

    private Long time;

    private String fileName;

    private Integer stallId;

    private Integer peopleNum;


    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getStallId() {
        return stallId;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

}

