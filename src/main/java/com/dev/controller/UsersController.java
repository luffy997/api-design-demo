package com.dev.controller;


import cn.hutool.crypto.SecureUtil;
import com.dev.entity.Users;
import com.dev.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 路飞
 * @since 2020-10-31
 */
@RestController
@Api(tags = "用户接口")
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public boolean addser(@RequestBody @Valid Users user) {
        //这里为了测试方便直接使用mybatisplus封装的方法
       return usersService.save(user);
    }

    @ApiOperation("查询用户")
    @PostMapping("/getUser")
    public Users getUser(@RequestParam int userId){
         return  usersService.getById(userId);
    }

    //整合shiro
    @ApiOperation("用户注册")
    @PostMapping("/registerUser")
    public boolean register(@RequestBody @Valid Users users){
        try {
            return usersService.register(users);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //整合shiro
    @ApiOperation("用户登录")
    @PostMapping("/loginUser")
    public String login(@RequestBody Users users){

        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(users.getUsername(),users.getPassword()));
            return "1000";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "1001";
    }



}

