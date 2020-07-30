package com.xhs.datasource.demo.service.impl;

import com.xhs.datasource.demo.mapper.User2Mapper;
import com.xhs.datasource.demo.mapper.UserMapper;
import com.xhs.datasource.demo.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author xuhan  build  2019/3/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserMapper mapper;
    @Resource
    private User2Mapper mapper2;

    @Test
    @Transactional
    public void findUserById() {
        User user = mapper.findUserById(29);
//        System.out.println(user.getUserName());
    }

    @Test
    public void findUserById2() {
    }

    @Test
    public void updateUserDeviceById() {
    }

    @Test
    public void updateUserNameById() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}