package com.xhs.datasource.demo.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhan  build  2019/1/24
 */
@Configuration
public class MyDataSource extends AbstractRoutingDataSource {


    public MyDataSource() {

        HashMap<Object,Object> map = new HashMap<Object, Object>();
        DriverManagerDataSource driverManagerDataSource1 = new DriverManagerDataSource();
        driverManagerDataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource1.setPassword("123456");
        driverManagerDataSource1.setUsername("root");
        driverManagerDataSource1.setUrl("jdbc:mysql://127.0.0.1:3306/weguarddb?characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        map.put("127.0.0.1",driverManagerDataSource1);

        DriverManagerDataSource driverManagerDataSource2 = new DriverManagerDataSource();
        driverManagerDataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource2.setPassword("123456");
        driverManagerDataSource2.setUsername("root");
        driverManagerDataSource2.setUrl("jdbc:mysql://10.10.127.176:3306/weguarddb?characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        map.put("10.10.127.176",driverManagerDataSource2);

        setTargetDataSources(map);
        setDefaultTargetDataSource(driverManagerDataSource1);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return MyDataSourceSwitch.getDataSourceName();
    }


}
