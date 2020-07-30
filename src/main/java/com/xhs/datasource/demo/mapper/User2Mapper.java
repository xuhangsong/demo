package com.xhs.datasource.demo.mapper;

import com.xhs.datasource.demo.model.User;

/**
 * @author xuhan  build  2019/1/24
 */
public interface User2Mapper {
    User findUserById(int id);
    boolean updateUserNameById(int id,String name);
}
