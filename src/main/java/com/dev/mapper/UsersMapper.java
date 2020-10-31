package com.dev.mapper;

import com.dev.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 路飞
 * @since 2020-10-31
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {

    //注册用户
    @Insert("insert into users(username,password,salt,user_tel,user_qq,user_mail,user_avatar,create_time,update_time) values( #{username} , #{password} , #{salt},#{user_tel},#{user_qq},#{user_mail},#{user_avatar},now(),now())")
    boolean register(Users user);

    //用户名查询
    @Select("select user_id,username,password,salt from users where  username=#{username}")
    Users findByUserName(String username);

}
