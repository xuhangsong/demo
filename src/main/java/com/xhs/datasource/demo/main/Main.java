package com.xhs.datasource.demo.main;

import java.util.Scanner;

/**
 * @author xuhan  build  2019/5/22
 */
public class Main  {
    public static String[] strs ;

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        Long[] results = new Long[line];
        strs = new String[line];
        for(int i=0;i<line;i++){
            strs[i] = scanner.nextLine();
            if(strs[i].equals("")){
                i--;
                continue;
            }
            int xNum = 0;
            int xcache =0;
            int jNum = 0;
            long count = 0;
            long preCount = 0;
            long prePreCount = 0;
            char now = 'X';
            int bNum = 0;
            int otherCount = 0;
            for(int x=0;x<strs[i].length();x++){
                if(strs[i].charAt(x)=='X'){
                    //如果之前是B，则表示进行了计算，则jNum肯定为0，将当前读取改为X
                    if(now=='B'){
                        xNum++;
                        now = 'X';
                        //如果当前是在读J，就是前面有J计数，但没有和B进行结算，则需要将X缓存起来，不能立即进入排序
                    }else if(now=='J'){
                        xcache++;
                    }else {
                        xNum++;
                    }
                    //当前字符为J且xNum>0则进入J计数，且当前读取改为J
                }else if(strs[i].charAt(x)=='J'&&xNum>0){
                       now = 'J';
                       jNum++;
                       //判断当前是否有缓存的X，如果有则表示缓存的X可以和该次J进行组合，需要进行统计，因为J是一次一次进入，则组合的次数是X缓存个数
                       if(xcache!=0){
                           otherCount+=xcache;
                       }
                }
                else if(strs[i].charAt(x)=='B'){
                    //只要是B，就进行计算
                    //当前进入的B是第几次，目的是保存前面2次的count结果，因为后续直接将上次的count*2，每次都会多算了上上次的count总数，需要减去
                    bNum++;
                    if(bNum==1){
                        preCount = 0;
                        prePreCount = 0;
                    }else{
                        prePreCount = preCount;
                        preCount = count;
                    }
                    if(jNum>0){
                        count = count*2+(xNum*jNum)-prePreCount+otherCount;
                        jNum=0;
                    }else{
                        count = count*2-prePreCount;
                    }
                    //计算完后将除了xNum以外的其它计数都清空
                    //将缓存的xcache添加到xNum中
                    now='B';
                    xNum = xNum+xcache;
                    xcache = 0;
                    otherCount = 0;
                }
            }
            results[i]=count;
        }
        for(int i=0;i<results.length;i++){
            System.out.println(results[i]%1000000007);
        }
            scanner.close();
    }
}
