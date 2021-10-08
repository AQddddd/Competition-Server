package org.xpef.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.xpef.server.constrants.UserConstrant;
import org.xpef.server.mapper.UserMapper;
import org.xpef.server.model.po.User;
import org.xpef.server.model.po.UserExample;
import org.xpef.server.service.UserService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByEmail(String email) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();

        criteria.andEmailEqualTo(email);
        criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);

        List<User> users=userMapper.selectByExample(example);
        if (users==null||users.isEmpty())
            return null;
        else return users.get(0);
    }

    @Override
    public User getUserByName(String name) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();

        criteria.andNameEqualTo(name);
        criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);

        List<User> users=userMapper.selectByExample(example);
        if (users==null||users.isEmpty())
            return null;
        else return users.get(0);
    }

    @Override
    public Boolean updateUser(User user) {
        user.setGmtModified(LocalDateTime.now());

        int ret=userMapper.updateByPrimaryKeySelective(user);
        return ret > 0;
    }
}
