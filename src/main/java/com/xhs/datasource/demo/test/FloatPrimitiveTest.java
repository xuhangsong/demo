package com.xhs.datasource.demo.test;

/**
 * @author xuhan  build  2019/6/17
 */
public class FloatPrimitiveTest {

        public static void main(String[] args) {
            float a = 0.9f - 0.8f;
            float b = 0.7f - 0.6f;
            System.out.println(a);
            System.out.println(b);
            if (a == b) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

}
