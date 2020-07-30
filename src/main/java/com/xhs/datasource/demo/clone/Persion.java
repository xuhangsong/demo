package com.xhs.datasource.demo.clone;

/**
 * @author xuhan  build  2020/2/29
 */
public class Persion implements Cloneable{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public Persion clone() throws CloneNotSupportedException {
        return (Persion) super.clone();
    }
}
