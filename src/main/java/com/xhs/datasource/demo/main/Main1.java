package com.xhs.datasource.demo.main;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author xuhan  build  2019/5/22
 */
public class Main1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        Long[] results = new Long[line];
        for(int i=0;i<line;i++){
            String input = scanner.nextLine();
            if(input.equals("")){
                i--;
                continue;
            }
            long xNum = 0;
            long xjNum = 0;
            long count = 0;
            for(int x=0;x<input.length();x++){
                if(input.charAt(x)=='X'){
                    xNum++;
                }else if(input.charAt(x)=='J'&&xNum>0){
                       xjNum+=xNum;
                }
                else if(input.charAt(x)=='B'){
                    count += xjNum;
                }
            }
            results[i]=count;
        }
        for(int i=0;i<results.length;i++){
            System.out.println(results[i]%1000000007);
        }
        try {
            scanner.close();
        }catch(Exception e){

        }finally {

        }
    }




}
