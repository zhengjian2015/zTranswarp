package com.zhengj.service;

import com.zhengj.common.ApiException;
import com.zhengj.dao.UserMapper;
import com.zhengj.enums.ApiError;
import com.zhengj.model.LocalAuth;
import com.zhengj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    private UserMapper userMapper;

    public User getById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getUsersByIds(long... ids) {
        if (ids.length == 0) {
            return new ArrayList<>();
        }
        if (ids.length > 100) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "id", "Too many ids.");
        }
        Object[] params = Arrays.stream(ids).mapToObj(id -> id).toArray();
        List<Long> myIds = new ArrayList<>();
        for(Object ob:params) {
            myIds.add(Long.valueOf(ob.toString()));
        }
        List<User> users = userMapper.getUsersByIds(myIds);
        return users;
    }


    public User fetchUserByEmail(String email) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("email",email);
        List<User> userList = userMapper.selectByExample(example);
        return userList.get(0);
    }


    public LocalAuth fetchLocalAuthByUserId(Long userId) {
        return this.userMapper.getLocalAuthByUserId(userId).get(0);
    }

}
