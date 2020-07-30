package com.xhs.datasource.demo.datasource;

/**
 * @author xuhan  build  2019/1/24
 */
public class MyDataSourceSwitch {
    private final static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static String getDataSourceName(){
        return threadLocal.get();
    }

    public static void setDataSourceName(String name){
        threadLocal.set(name);
    }

    public static void removeDataSourceName(){
        threadLocal.remove();
    }


}
