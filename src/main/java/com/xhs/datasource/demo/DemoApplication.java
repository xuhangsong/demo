package com.xhs.datasource.demo;

import com.xhs.datasource.demo.datasource.MyDataSourceSwitch;
import com.xhs.datasource.demo.mapper.User2Mapper;
import com.xhs.datasource.demo.mapper.UserMapper;
import com.xhs.datasource.demo.model.User;
import com.xhs.datasource.demo.service.UserService;
import com.xhs.datasource.demo.utils.JwtTokenUtils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@MapperScan("com.xhs.datasource.demo.mapper")
//@SoulClient(path = "/", desc = "")
@RequestMapping("/")
public class DemoApplication {

    @Autowired
    private UserService userService;
    @Resource
    private UserMapper mapper;
    @Resource
    private User2Mapper mapper2;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


//    @SoulClient(path = "/findUserByLocal", desc = "test")
    @RequestMapping("/findUserByLocal")
    public User findUserBy10(){

        System.out.println(MyDataSourceSwitch.getDataSourceName());
        User user = userService.findUserById(29);
//        User user2 = userService.findUserById2(id);
        return user;
    }

    @RequestMapping("/findUserBy127")
    public User findUserBy127(int id)  {
        MyDataSourceSwitch.setDataSourceName("10.10.127.176");
        System.out.println(MyDataSourceSwitch.getDataSourceName());
        User user = userService.findUserById(id);
        User user2 = userService.findUserById2(id);
        MyDataSourceSwitch.removeDataSourceName();
        return user;
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password, HttpServletResponse response){
        System.out.println("登录名为："+name+"密码为："+password);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("name",name);
        map.put("pwd",password);
//        System.out.println(DateTime.now().plusSeconds(100).toDate());
        map.put("exp", (System.currentTimeMillis())/1000+100);
        String token = JwtTokenUtils.generatorToken(map);
        response.setHeader("Set-Cookie","access_token="+token);
        return token;
    }
}

