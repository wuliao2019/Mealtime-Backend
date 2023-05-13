package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Users;

import java.util.List;

public interface UsersDao {
    int insert(Users users);

    List<Users> queryByName(Users users);

    List<Users> checkUser(Users users);
}
