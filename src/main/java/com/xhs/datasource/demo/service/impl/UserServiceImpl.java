package com.xhs.datasource.demo.service.impl;

import com.xhs.datasource.demo.mapper.User2Mapper;
import com.xhs.datasource.demo.mapper.UserMapper;
import com.xhs.datasource.demo.model.User;
import com.xhs.datasource.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xuhan  build  2019/1/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;
    @Resource
    private User2Mapper mapper2;

    @Override

    public User findUserById(int id) {
        User u1 = mapper.findUserById(id);
        User u3 = mapper.findUserById(id);
        User u2 = mapper2.findUserById(id);
        return u2;
    }
    @Override
    public User findUserById2(int id) {
        return mapper2.findUserById(id);
    }

    @Override
    public boolean updateUserDeviceById(int id, String device) {
        return mapper.updateUserDeviceById(id,device);
    }

    @Override
    public boolean updateUserNameById(int id, String name) {
        return mapper2.updateUserNameById(id,name);
    }
}
