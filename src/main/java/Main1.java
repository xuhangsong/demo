import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=br.readLine())!=null){
            String[] array1 = input.split(" ");
            String[] array2 = br.readLine().split(" ");
            Integer k = Integer.parseInt(br.readLine());
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for(int i=1;i<array1.length;i++){
                arrayList1.add(Integer.parseInt(array1[i]));
            }
            for(int i=1;i<array2.length;i++){
                arrayList2.add(Integer.parseInt(array2[i]));
            }
            arrayList1.sort(Integer::compareTo);
            arrayList2.sort(Integer::compareTo);
            Integer result = arrayList1.get(0)+arrayList2.get(0);
            Integer numIndex1 = 0;
            Integer numIndex2 = 0;
            Integer arrayListLen1 = arrayList1.size();
            Integer arrayListLen2 = arrayList2.size();
            HashSet<String> hashSet = new HashSet<>();
            for(int x=1;x<k;x++){

                Integer index11= numIndex1;
                Integer index12 = numIndex2;
                Integer index21 = numIndex1;
                Integer index22 = numIndex2;
                if(index11<arrayListLen1-1){
                    index11++;
                    index12 = 0;
                }else{
                    index11 =0;
                    index12++;
                }
                if(index22<arrayListLen2-1){
                    index21= 0;
                    index22++;
                }else{
                    index21++;
                    index22 = 0;
                }
                int v1 = arrayList1.get(index11)+arrayList2.get(index12);
                int v2 = arrayList1.get(index21)+arrayList2.get(index22);
                if(v1==v2){
                    if(hashSet.add(""+index11+index12)){
                        result+=v1;
                        numIndex1 = index11;
                        numIndex2 = index12;
                    }else{
                        if(hashSet.add(""+index21+index22)){
                            result+=v2;
                            numIndex1 = index21;
                            numIndex2 = index22;
                        }

                    }

                }
                else if(v1<v2){
                    if(hashSet.add(""+index11+index12)){
                        result+=v1;
                    }
                    numIndex1 = index11;
                    numIndex2 = index12;
                }else{
                    if(hashSet.add(""+index21+index22)){
                        result+=v2;
                    }
                    numIndex1 = index21;
                    numIndex2 = index22;

                }

//               if(arrayList1.get(index1)>arrayList2.get(index2)&&(index2<arrayListLen2-1)){
//                   numIndex2++;
//                   numIndex1=0;
//               }else{
//                   if(index1<arrayListLen1-1){
//                       numIndex1++;
//                       numIndex2=0;
//                   }else if(index2<arrayListLen2-1){
//                       numIndex2++;
//                       numIndex1=0;
//                   }
//               }
//               result+=arrayList1.get(numIndex1);
//               result+=arrayList2.get(numIndex2);
            }
            System.out.println(result);
        }


        }



    }

