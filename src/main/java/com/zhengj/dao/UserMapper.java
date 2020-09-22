package com.zhengj.dao;

import com.zhengj.model.LocalAuth;
import com.zhengj.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

    List<User> getUsersByIds(@Param("ids") List<Long> ids);


    List<LocalAuth> getLocalAuthByUserId(@Param("userId") Long userId);
}
