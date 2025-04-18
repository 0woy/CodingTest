package Greedy;

import java.io.*;
import java.util.*;

public class N_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        Queue<Integer> empty = new ArrayDeque<>();
        List<Integer> weird = new LinkedList<>();

        while (n-- > 0){
            int predict = Integer.parseInt(br.readLine());
            if(predict<arr.length){
                arr[predict]++;
            }else{
                weird.add(predict);
            }
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0){
                empty.offer(i);
            }
        }

        long total =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>1){
                while (arr[i]>1){
                    total += Math.abs(i-empty.poll());
                    arr[i]--;
                }
            }
        }
        while (!weird.isEmpty()){
            total+= Math.abs(weird.remove(0)-empty.poll());
        }

        bw.write(total+"");
        bw.flush();
        bw.close();
    }
}
