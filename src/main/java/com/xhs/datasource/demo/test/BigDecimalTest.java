package com.xhs.datasource.demo.test;

import java.math.BigDecimal;

/**
 * @author xuhan  build  2019/6/17
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}
