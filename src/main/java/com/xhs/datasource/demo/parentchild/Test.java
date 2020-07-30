package com.xhs.datasource.demo.parentchild;

/**
 * @author xuhan  build  2019/12/13
 */
public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        child.setName("xhs");
        child.setAge(18);
        System.out.println((child).getName());
        System.out.println((child));
    }
}
