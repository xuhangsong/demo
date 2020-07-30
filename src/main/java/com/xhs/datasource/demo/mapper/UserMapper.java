package com.xhs.datasource.demo.mapper;

import com.xhs.datasource.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xuhan  build  2019/1/24
 */
public interface UserMapper {
//    @Select("select * from t_user where id = 28")
    User findUserById(int id);
    boolean updateUserDeviceById(@Param("id") int id,@Param("device") String device);
}
