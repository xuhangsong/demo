import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=br.readLine())!=null){
            int num = Integer.parseInt(input);
            int[][] arrays = new int[num][num];
            int moi=0;
            int moj=0;
            int bi=0;
            int bj=0;
            HashSet<String> hashSet = new HashSet<>();
            for(int i=0;i<num;i++){
                String[] strs = br.readLine().split(" ");
                for(int j=0;j<num;j++){
                    int v = Integer.parseInt(strs[j]);
                   arrays[i][j] = v;
                   if(v==-3){
                       moi=i;
                       moj=j;
                   }else if(v==-2){
                       bi=i;
                       bj=j;
                   }else if(v==-1){
                       hashSet.add(""+i+j);
                   }
                }
            }
            int stepNum = 0;
            int candy = 0;
            int index=0;
            while (index++<num*num){
                if(moi<num-1&&moi<bi&&!hashSet.contains((moi+1)+moj)){
                    moi++;
                    stepNum++;
                    candy+=arrays[moi][moj]>0?arrays[moi][moj]:0;

                }
                else if(moi>0&&moi>bi&&!hashSet.contains((moi-1)+moj)){
                    moi--;
                    stepNum++;
                    candy+=arrays[moi][moj]>0?arrays[moi][moj]:0;
            }
             else if(moj<num-1&&moj<bj&&!hashSet.contains(moi+(moj+1))){
                    moj++;
                    stepNum++;
                    candy+=arrays[moi][moj]>0?arrays[moi][moj]:0;

                }
                else if(moj>0&&moj>bi&&!hashSet.contains(moi+(moj-1))){
                    moj--;
                    stepNum++;
                    candy+=arrays[moi][moj]>0?arrays[moi][moj]:0;
                }
            }
            if(moi!=bi||moj!=bj){
                System.out.println(-1);
            }else{
                System.out.println(candy);
            }

        }


        }



    }

