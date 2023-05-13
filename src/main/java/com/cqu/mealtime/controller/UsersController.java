package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Users;
import com.cqu.mealtime.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<Integer> add(Users users) {
        if (this.usersService.queryByName(users).size() > 0)
            return ResponseEntity.ok(-1);
        return ResponseEntity.ok(this.usersService.insert(users));
    }

    @GetMapping
    public ResponseEntity<Boolean> checkExist(Users users) {
        return ResponseEntity.ok(this.usersService.queryByName(users).size() > 0);
    }

    @PostMapping("Login")
    public ResponseEntity<List<Users>> checkUser(Users users) {
        return ResponseEntity.ok(this.usersService.checkUser(users));
    }
}
