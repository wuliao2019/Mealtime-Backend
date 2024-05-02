package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.dao.UsersDao;
import com.cqu.mealtime.entity.Users;
import com.cqu.mealtime.service.UsersService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service("UsersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public int insert(Users users) {
        return this.usersDao.insert(users);
    }

    @Override
    public List<Users> queryByName(Users users) {
        return this.usersDao.queryByName(users);
    }

    @Override
    public List<Users> checkUser(Users users) {
        return this.usersDao.checkUser(users);
    }
}
