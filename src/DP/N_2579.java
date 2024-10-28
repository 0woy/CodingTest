package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2579 {
    /** Wrong
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stair = Integer.parseInt(br.readLine());
        int[] stairs = new int[stair+1];
        int[] score = new int[stair+1];
        stairs[0] =0;
        for(int i=1;i<stairs.length;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        for(int i=3;i<stairs.length;i++){
            score[i] = Math.max(score[i-3]+stairs[i-1],stairs[i-2])+stairs[i];
        }
        System.out.println(stairs[stairs.length-1]);
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        int[] score = new int[n+1];
        for(int i=1;i<=n;i++){
            stairs[i]=Integer.parseInt(br.readLine());
        }
        score[1]= stairs[1];
        for(int i=2;i<=n;i++) {
            if(i==2){
                score[i] = stairs[1]+stairs[2];
            }else if(i==3){
                score[i] = Math.max(stairs[1], stairs[2])+stairs[3];
            }
            else {
                score[i] = Math.max(score[i - 3] + stairs[i - 1], score[i - 2]) + stairs[i];
            }
        }
        System.out.println(score[n]);





    }
}
