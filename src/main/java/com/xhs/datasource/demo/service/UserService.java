package com.xhs.datasource.demo.service;

import com.xhs.datasource.demo.model.User;

/**
 * @author xuhan  build  2019/1/24
 */
public interface UserService {

    User findUserById(int id);
    User findUserById2(int id);
    boolean updateUserDeviceById(int id,String device);
    boolean updateUserNameById(int id,String name);
}
