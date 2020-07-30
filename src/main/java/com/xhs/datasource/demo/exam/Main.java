package com.xhs.datasource.demo.exam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xuhan  build  2020/6/6
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());
        String[] strArray = new String[num];
        StringBuilder result = new StringBuilder();

        for(int i=0;i<num;i++){
            strArray[i] = br.readLine();
        }
        for(int i=0;i<num;i++){
            String str = strArray[i];
            int len = str.length();

            int arrLen = len/8;
            int fall = len%8;
            if(fall>0){
                arrLen++;
            }
            for(int x=0;x<arrLen;x++){
                if(x==arrLen-1&&fall>0){
                    result.append(str, x*8, len);
                    for(int y=0;y<8-fall;y++){
                        result.append("0");
                    }
                    result.append("\n");
                }else{
                    result.append(str, x*8, (x+1)*8).append("\n");
                }

            }

        }
        System.out.println(result.toString().trim());
    }


}
