package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11047 {
    public static int findLastIdx(int [] money,int goal){
        int start =0;
        int end =money.length-1;
        while(start<end){
            int half = (start+end)/2;
            if(money[half] == goal){
                return half;
            }

            if(goal / money[half] ==0){
                end = half-1;
            }
            else{
                start = half+1;
            }
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int [] money = new int[type];
        for(int i=0;i<type;i++){
            money[i] = Integer.parseInt(br.readLine());
        }
        int max =findLastIdx(money, goal);
        int count =0;
        while(goal>0){
            count+= goal/money[max];
            goal %=money[max--];
        }
        System.out.println(count);
    }
}
