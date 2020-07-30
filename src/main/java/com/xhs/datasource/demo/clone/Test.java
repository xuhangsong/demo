package com.xhs.datasource.demo.clone;

/**
 * @author xuhan  build  2020/2/29
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Persion p1 = new Persion();
        p1.setAge(18);
        p1.setName("xhs");
        Persion p2 = p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.getName()==p2.getName());

    }
}
