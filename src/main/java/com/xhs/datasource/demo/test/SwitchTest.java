package com.xhs.datasource.demo.test;

/**
 * @author xuhan  build  2019/6/17
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
