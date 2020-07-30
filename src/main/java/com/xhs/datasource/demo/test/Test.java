package com.xhs.datasource.demo.test;

import java.util.*;

/**
 * @author xuhan  build  2019/4/15
 */
public class Test {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random random = new Random();
        for(int i=0;i<10;){
//            if(treeSet.add(random.nextInt(90)))
            if(treeSet.add(10-i))
                i++;
        }
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        Integer[] nums = new Integer[treeSet.size()];
        treeSet.toArray(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void test(){
        System.out.println("test");
    }
    public void test2(){
        System.out.println("test2");
    }
}
class Test1{

}
