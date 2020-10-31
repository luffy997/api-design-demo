package com.dev.service;

import com.dev.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 路飞
 * @since 2020-10-31
 */
public interface UsersService extends IService<Users> {
    //注册用户
    boolean register(Users user);

    //用户名查询
    Users findByUserName(String username);

}
