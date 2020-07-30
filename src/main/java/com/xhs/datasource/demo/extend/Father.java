package com.xhs.datasource.demo.extend;

/**
 * @author xuhan  build  2019/4/8
 */
public class Father {
    public  String fname;

    public String getFname() {
        return fname;
    }

    public Father(String name) {
        this.name = name;
        this.fname = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
