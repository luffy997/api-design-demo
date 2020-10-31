package com.dev.service.impl;

import com.dev.entity.Users;
import com.dev.mapper.UsersMapper;
import com.dev.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.util.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 路飞
 * @since 2020-10-31
 */
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean register(Users user) {
        //明文密码 md5+salt+hash
        //1.生成随机盐
        String salt = SaltUtils.getSalt(8);
        //2.将随机盐保存到数据库
        user.setSalt(salt);
        //3.明文密码进行md5+salt+hash
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
       return usersMapper.register(user);
    }

    @Override
    public Users findByUserName(String username) {
        return usersMapper.findByUserName(username);
    }
}
