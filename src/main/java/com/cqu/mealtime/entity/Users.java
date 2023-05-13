package com.cqu.mealtime.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2023-05-13 15:11:50
 */
public class Users implements Serializable {
    @Serial
    private static final long serialVersionUID = -96051640525221393L;

    private Integer usrId;

    private String userName;

    private String userPwd;


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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}

