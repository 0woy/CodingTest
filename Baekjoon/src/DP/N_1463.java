package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N_1463 {
    static int [] arr;
    static Queue<Integer> que;
    public static void calc(int pos, int count){
        if(arr[pos]!=0){
            arr[pos] = Math.min(arr[pos], count+1);
        }else{
            arr[pos]=count+1;
        }
        que.add(pos);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        que =  new ArrayDeque<>();

        int x = Integer.parseInt(br.readLine());
        if(x ==1){
            System.out.println(0);
            return;
        }
        arr = new int[x+1];
        arr[x] = 0;

        que.add(x);
        while(true){
            int next = que.poll();
            if(next %3==0){
                calc(next/3, arr[next]);
            }
            if(next %2==0){
                calc(next/2, arr[next]);
            }
            calc(next-1, arr[next]);

            if(arr[1]>0){
                System.out.println(arr[1]);
                return ;
            }
        }

    }
}
