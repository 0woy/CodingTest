package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] house = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            house[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);
        int half =-1;
        if(n==1){
            half=house[0];
            System.out.println(half);
            return;
        }

        if(n%2==0){
            half = house[n/2-1];
        }else{
            half = house[n/2];
        }
        System.out.println(half);

    }
}
