package com.cqu.mealtime.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Discussion)实体类
 *
 * @author makejava
 * @since 2023-05-06 17:04:58
 */
public class Discussion implements Serializable {
    @Serial
    private static final long serialVersionUID = -50597207427147525L;

    private Integer discussionId;

    private String discussionName;

    private String discussionContent;

    private String discussionTime;

    private Integer canId;

    private Integer stallId;

    private Integer usrId;
    private String userName;


    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public String getDiscussionName() {
        return discussionName;
    }

    public void setDiscussionName(String discussionName) {
        this.discussionName = discussionName;
    }

    public String getDiscussionContent() {
        return discussionContent;
    }

    public void setDiscussionContent(String discussionContent) {
        this.discussionContent = discussionContent;
    }

    public String getDiscussionTime() {
        return discussionTime;
    }

    public void setDiscussionTime(String discussionTime) {
        this.discussionTime = discussionTime;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public Integer getStallId() {
        return stallId;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

