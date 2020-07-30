package com.xhs.datasource.demo.extend;

/**
 * @author xuhan  build  2019/4/8
 */
public class Child extends Father{
    public String fname;
    public Child(String name) {
        super(name+"father");
        this.setName(name);
        this.fname = name;
    }

    public static void main(String[] args) {
        Child c = new Child("Amy");
        System.out.println(c.fname);
        System.out.println(((Father) c).fname);
    }
}
