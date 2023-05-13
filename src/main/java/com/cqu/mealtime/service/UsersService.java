package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Users;

import java.util.List;

public interface UsersService {
    int insert(Users users);

    List<Users> checkUser(Users users);
    List<Users> queryByName(Users users);
}
