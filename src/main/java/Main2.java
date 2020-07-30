import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=br.readLine())!=null){
            Integer H = Integer.parseInt(input.split(" ")[0]);
            Integer n = Integer.parseInt(input.split(" ")[1]);

            String[] hArray = br.readLine().split(" ");
            ArrayList<Integer> mins = new ArrayList<>();
            ArrayList<Integer> maxs = new ArrayList<>();
            ArrayList<Integer> equs = new ArrayList<>();
            Integer maxDiff = 0;
            for(String s:hArray){
                Integer diff = Integer.parseInt(s)-H;
                if(diff<0){
                    mins.add(Integer.parseInt(s));
                    diff = -diff;
                }else if(diff>0){
                    maxs.add(Integer.parseInt(s));
                }else{
                    equs.add(Integer.parseInt(s));
                }
                if(maxDiff<diff){
                    maxDiff = diff;
                }
            }
            for(Integer num:equs){
                System.out.print(num+" ");
            }
            for(int x=1;x<=maxDiff;x++){
                for(int y=0;y<mins.size();y++){
                    if(mins.get(y)+x==H){
                        System.out.print(mins.get(y)+" ");
                    }
                }
                for(int z=0;z<maxs.size();z++){
                    if(maxs.get(z)-x==H){
                        System.out.print(maxs.get(z)+" ");
                    }
                }
            }


        }


        }



    }

