package com.xhs.datasource.demo.test;

/**
 * @author xuhan  build  2019/6/17
 */
public class FloatWrapperTest {
    public static void main(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        System.out.println(a);
        System.out.println(b);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
